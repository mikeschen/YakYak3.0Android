package com.mikeschen.www.yakyak.models;

/**
 * Created by Guest on 5/3/16.
 */
public class Reply {
        String reply;
        String replyPushId;

        public Reply(String reply) {
            this.reply = reply;
        }

        public String getReply() {
            return reply;
        }

        public String getReplyPushId() {
            return replyPushId;
        }

        public void setReplyPushId(String replyPushId) {
            this.replyPushId = replyPushId;
        }
    }
