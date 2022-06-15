package hexagonal.api.member.application.service;

import hexagonal.api.member.application.port.in.RegisterMemberUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterMemberService implements RegisterMemberUseCase {

    @Override
    public boolean registerMember() {
        return false;
    }
}
