package com.hcg.mastermicroservices.suite;

import com.hcg.mastermicroservices.UserServiceImplTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserServiceImplTest.class
})
public class UserTestSuite {
}
