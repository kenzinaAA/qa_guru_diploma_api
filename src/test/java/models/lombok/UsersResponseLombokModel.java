package models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class UsersResponseLombokModel {
        private UserData data;
        private Support support;

        @Data
        public static class UserData {
            private int id;
            private String email;
            private String first_name;
            private String last_name;
            private String avatar;
        }

        @Data
        public static class Support {
            private String url;
            private String text;
        }
    }
