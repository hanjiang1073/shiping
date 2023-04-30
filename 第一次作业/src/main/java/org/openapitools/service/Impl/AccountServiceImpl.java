package org.openapitools.service.Impl;

import org.openapitools.model.User;
import org.openapitools.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public boolean addUser(User user) {
        if(user.getId().intValue()> 4000 || user.getId().intValue()<1){
            return false;
        }
        return true;
    }
}
