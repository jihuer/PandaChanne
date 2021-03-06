package com.example.a12710.pandachannel.model.bean;

import java.util.List;

/**
 * 爱生活，爱代码
 * 创建于：2017/7/18 11:38
 * 作 者：T
 * 微信：704003376
 */

public class OriginalBean {

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * url : http://live.ipanda.com/2017/07/22/VIDEEtgyBdOfRMl0OPOIPZbc170722.shtml
         * image : http://p1.img.cctvpic.com/photoworkspace/2017/07/22/2017072215265151564.jpg
         * title : 这是扣手手？还是抠脚脚？
         * videoLength : 00:18
         * id : TITE1500732524125134
         * daytime : 2017-07-23
         * type : 2
         * pid : 3126753a3e8041d3837101264932f539
         * vid :
         * order : 1
         */

        private String url;
        private String image;
        private String title;
        private String videoLength;
        private String id;
        private String daytime;
        private String type;
        private String pid;
        private String vid;
        private String order;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getVideoLength() {
            return videoLength;
        }

        public void setVideoLength(String videoLength) {
            this.videoLength = videoLength;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDaytime() {
            return daytime;
        }

        public void setDaytime(String daytime) {
            this.daytime = daytime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }
    }
}
