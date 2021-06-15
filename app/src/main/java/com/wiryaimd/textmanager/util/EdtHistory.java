package com.wiryaimd.textmanager.util;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.widget.EditText;

import com.wiryaimd.textmanager.SessionManager;

import java.util.LinkedList;

import javax.inject.Inject;

public class EdtHistory {

    private SessionManager sessionManager;
    private EditText edtMain;

    private HistoryData historyData;

    private boolean isUndoOrRedo = false;

    private CharSequence beforeChange, afterChange;

    @Inject
    public EdtHistory(SessionManager sessionManager){
        this.sessionManager = sessionManager;
    }

    public void initEdtHistory(){
        this.edtMain = sessionManager.getTmEditor();
        this.historyData = new HistoryData();

        edtMain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (isUndoOrRedo){
                    return;
                }
                beforeChange = s.subSequence(start, start + count);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isUndoOrRedo){
                    return;
                }
                afterChange = s.subSequence(start, start + count);
                historyData.add(new ItemData(start, beforeChange, afterChange));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void undo(){
        ItemData itemData = historyData.getPrevious();
        if (itemData == null){
            return;
        }

        Editable editable = edtMain.getEditableText();
        int start = itemData.startCursor;
        int end = start + (itemData.textAfter != null ? itemData.textAfter.length() : 0);

        // TODO replace current text ke reod
        isUndoOrRedo = true;
        editable.replace(start, end, itemData.textBefore);
        isUndoOrRedo = false;

        // TODO remove underline pada edittext (diberi suggestion)
        for (Object o : editable.getSpans(0, editable.length(), UnderlineSpan.class)) {
            editable.removeSpan(o);
        }

        Selection.setSelection(editable, itemData.textBefore == null ? start : start + itemData.textBefore.length());
    }

    public void redo(){
        ItemData itemData = historyData.getNext();
        if (itemData == null){
            return;
        }

        Editable editable = edtMain.getEditableText();
        int start = itemData.startCursor;
        int end = start + (itemData.textBefore != null ? itemData.textBefore.length() : 0);

        // TODO replace current text ke reod
        isUndoOrRedo = true;
        editable.replace(start, end, itemData.textAfter);
        isUndoOrRedo = false;

        // TODO remove underline pada edittext (diberi suggestion)
        for (Object o : editable.getSpans(0, editable.length(), UnderlineSpan.class)) {
            editable.removeSpan(o);
        }

        Selection.setSelection(editable, itemData.textAfter == null ? start : start + itemData.textAfter.length());

    }

    public EditText getEdtMain(){
        return edtMain;
    }

    private final class HistoryData{

        private int posHistory = 0;
        private int maxHistory = 45;

        private ItemData itemData;

        private final LinkedList<ItemData> history = new LinkedList<>();

        /**
         * menambah data history saat diketik
         */
        public void add(ItemData itemData){
            // TODO menghapus data history yang sudah di undo sebelumnya, berdasarkan posHistory nya
            while (history.size() > posHistory){
                history.removeLast();
            }
            history.add(itemData);
            posHistory += 1;

            if (posHistory >= maxHistory){
                trimHistory();
            }

        }

        /**
         * clear data history
         */
        public void clear(){
            posHistory = 0;
            history.clear();
        }

        /**
         * mengganti data history awal jika maxHistory sudah melebihi value
         */
        public void trimHistory(){
            while (history.size() >= maxHistory){
                history.removeFirst();
                posHistory -= 1;
            }

            if (posHistory < 0){
                posHistory = 0;
            }
        }

        /**
         * get text sebelumnya pada datahistory (undo)
         */
        public ItemData getPrevious(){
            if (posHistory == 0){
                return null;
            }
            posHistory -= 1;
            return history.get(posHistory);
        }

        /**
         * get text yang pernah di undo (redo)
         */
        public ItemData getNext(){
            if (posHistory >= history.size()){
                return null;
            }
            ItemData itemData = history.get(posHistory);
            posHistory += 1;
            return itemData;
        }

    }

    private final class ItemData{

        private final int startCursor;
        private final CharSequence textBefore;
        private final CharSequence textAfter;

        public ItemData(int startCursor, CharSequence textBefore, CharSequence textAfter) {
            this.startCursor = startCursor;
            this.textBefore = textBefore;
            this.textAfter = textAfter;
        }
    }

}
