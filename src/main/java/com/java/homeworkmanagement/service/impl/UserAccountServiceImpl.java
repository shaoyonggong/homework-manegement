package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.dao.UserAccountMapper;
import com.java.homeworkmanagement.pojo.UserAccountPO;
import com.java.homeworkmanagement.service.IUserAccountService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccountPO> implements IUserAccountService {

}
