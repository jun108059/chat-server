package hexagonal.api.chat.application.port.in;

import hexagonal.api.chat.adapter.in.web.response.GetChatListRes;

import java.util.List;

public interface GetChatListQuery {

    List<GetChatListRes> getChatList(Long roomId);
}
