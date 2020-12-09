package com.example.mymvp.Bean;

import java.util.List;

/**
 * @author zzh
 * @description:
 * @date :2020/12/4 13:43
 */
public class ArticleInfo {

    /**
     * id : 30
     * phone : 15288888888
     * name : 123
     * province : 安徽省
     * city : 合肥市
     * area : 瑶海区
     * isOpen : 1
     * createDate : 2020-11-12 15:31:40
     * list : []
     * storeEntity : {"id":0,"phone":null,"name":null,"province":null,"city":null,"area":null,"isOpen":0,"isDelete":0,"createDate":null,"updateDate":null,"sname":null,"scode":null,"saddress":null}
     * sname : 123
     * scode : 123
     * saddress : 21333
     */

    private int id;
    private String phone;
    private String name;
    private String province;
    private String city;
    private String area;
    private int isOpen;
    private String createDate;
    private StoreEntityBean storeEntity;
    private String sname;
    private String scode;
    private String saddress;
    private List<?> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public StoreEntityBean getStoreEntity() {
        return storeEntity;
    }

    public void setStoreEntity(StoreEntityBean storeEntity) {
        this.storeEntity = storeEntity;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public static class StoreEntityBean {
        /**
         * id : 0
         * phone : null
         * name : null
         * province : null
         * city : null
         * area : null
         * isOpen : 0
         * isDelete : 0
         * createDate : null
         * updateDate : null
         * sname : null
         * scode : null
         * saddress : null
         */

        private int id;
        private Object phone;
        private Object name;
        private Object province;
        private Object city;
        private Object area;
        private int isOpen;
        private int isDelete;
        private Object createDate;
        private Object updateDate;
        private Object sname;
        private Object scode;
        private Object saddress;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getPhone() {
            return phone;
        }

        public void setPhone(Object phone) {
            this.phone = phone;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getProvince() {
            return province;
        }

        public void setProvince(Object province) {
            this.province = province;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public Object getArea() {
            return area;
        }

        public void setArea(Object area) {
            this.area = area;
        }

        public int getIsOpen() {
            return isOpen;
        }

        public void setIsOpen(int isOpen) {
            this.isOpen = isOpen;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public Object getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Object createDate) {
            this.createDate = createDate;
        }

        public Object getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Object updateDate) {
            this.updateDate = updateDate;
        }

        public Object getSname() {
            return sname;
        }

        public void setSname(Object sname) {
            this.sname = sname;
        }

        public Object getScode() {
            return scode;
        }

        public void setScode(Object scode) {
            this.scode = scode;
        }

        public Object getSaddress() {
            return saddress;
        }

        public void setSaddress(Object saddress) {
            this.saddress = saddress;
        }
    }
}
