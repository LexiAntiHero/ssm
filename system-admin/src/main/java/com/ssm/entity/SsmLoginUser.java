package com.ssm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SsmLoginUser implements Serializable{


        private static final long serialVersionUID = 1L;

        /**
         * user ID
         */
        private Long userId;
        /**
         * user sole token
         */
        private String token;
        /**
         * login date
         */
        private Date loginTime;
        /**
         * login IP address
         */
        private String ipaddr;

        /**
         * login address
         */
        private String loginLocation;
        /**
         * type of browser
         */
        private String browser;
        /**
         * operating system
         */
        private String os;
        /**
         * user information
         */
        private SsmUser ssmUser;


}
