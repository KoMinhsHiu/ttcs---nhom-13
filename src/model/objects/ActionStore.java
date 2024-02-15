/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.objects;

/**
 *
 * @author sidac
 */
public class ActionStore {
    private LogO data;
    private String typeAction; //delete , update , add
    private int index;
            /**
         * 
         * @param data
         * @param typeAction
         * @param index là index cho các action vào ra cùng 1 lúc
         */
        public ActionStore(LogO data, String typeAction, int index) {
            this.data = data;
            this.typeAction = typeAction;
            this.index = index;
        }



        public LogO getData() {
            return data;
        }

        public void setData(LogO data) {
            this.data = data;
        }

        public String getTypeAction() {
            return typeAction;
        }

        public void setTypeAction(String typeAction) {
            this.typeAction = typeAction;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }


}
