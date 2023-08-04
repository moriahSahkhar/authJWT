package org.demoAuthJWT.AuthJWT.service;

import lombok.AllArgsConstructor;
import org.demoAuthJWT.AuthJWT.Repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommonService {

    private UserRepo userRepo;


}
