package hexagonal.api.room.util;

import hexagonal.api.chat.adapter.in.web.response.GetChatListRes;
import hexagonal.api.member.adapter.in.web.response.GetMemberResponse;
import hexagonal.api.room.adapter.in.web.response.GetRoomRes;
import hexagonal.core.domain.jpa.ChatJpaEntity;
import hexagonal.core.domain.jpa.MemberJpaEntity;
import hexagonal.core.domain.jpa.RoomJpaEntity;

public class Translator {

    public static GetRoomRes toGetRoomResDto(RoomJpaEntity entity, String companyName) {
        return GetRoomRes.builder()
                .id(entity.getId())
                .companyId(entity.getCompanyId())
                .companyName(companyName)
                .build();
    }

    public static GetMemberResponse toGetMemberResDto(MemberJpaEntity entity) {
        return GetMemberResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .type(entity.getType())
                .build();
    }

    public static GetChatListRes toGetChatResDto(ChatJpaEntity entity) {
        return GetChatListRes.builder()
                .id(entity.getId())
                .content(entity.getContent())
                .roomId(entity.getRoomId())
                .senderId(entity.getSenderId())
                .build();
    }
}
