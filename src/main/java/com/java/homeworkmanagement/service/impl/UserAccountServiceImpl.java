package com.java.homeworkmanagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java.homeworkmanagement.mapper.UserAccountMapper;
import com.java.homeworkmanagement.pojo.UserAccountPO;
import com.java.homeworkmanagement.service.IUserAccountService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaoyonggong
 * @since 2021-02-24
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccountPO> implements IUserAccountService {

}
