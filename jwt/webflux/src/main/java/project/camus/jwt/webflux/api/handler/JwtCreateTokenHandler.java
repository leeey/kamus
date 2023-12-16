package project.camus.jwt.webflux.api.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import project.camus.common.util.ValidationUtil;
import project.camus.jwt.webflux.config.security.JwtTokenProvider;
import project.camus.jwt.webflux.api.dto.request.JwtCreateTokenRequestDto;
import project.camus.reactive.common.ResponseWrapper;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtCreateTokenHandler implements HandlerFunction<ServerResponse> {

    private final JwtTokenProvider jwtTokenProvider;

    @NonNull
    @Override
    public Mono<ServerResponse> handle(@NonNull ServerRequest request) {

        return request.bodyToMono(JwtCreateTokenRequestDto.class)
            .doOnNext(ValidationUtil::validate)
            .doOnNext(JwtCreateTokenRequestDto::validate)
            .flatMap(dto -> {
                String token = jwtTokenProvider.createToken(dto.getUsername());
                return ResponseWrapper.success(token);
            });
    }
}