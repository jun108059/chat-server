package hexagonal.api.chat.application.service;

import hexagonal.api.chat.adapter.in.web.response.GetChatListRes;
import hexagonal.api.chat.application.port.in.GetChatListQuery;
import hexagonal.api.chat.application.port.out.FindChatPort;
import hexagonal.api.room.util.Translator;
import hexagonal.core.domain.jpa.ChatJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetChatListService implements GetChatListQuery {

    private final FindChatPort findChatPort;

    @Override
    public List<GetChatListRes> getChatList(Long roomId) {
        List<ChatJpaEntity> chatByRoom = findChatPort.findChatByRoom(roomId);
        List<GetChatListRes> res = new ArrayList<>();
        for (ChatJpaEntity chatJpaEntity : chatByRoom) {
            GetChatListRes getChatListRes = Translator.toGetChatResDto(chatJpaEntity);
            res.add(getChatListRes);
        }
        return res;
    }
}
