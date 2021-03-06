package org.codingwater.dao;

import org.codingwater.BaseTest;
import org.codingwater.model.BaseJobInfo;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by water on 4/24/16.
 */
public class BaseJobInfoDAOTest extends BaseTest{

  @Autowired
  private BaseJobInfoDAO baseJobInfoDAO;

  @Test
  public void testSavePosition() throws Exception {
    BaseJobInfo baseJobInfo = new BaseJobInfo();
    baseJobInfo.setPositionId("L123");

//    System.out.println(baseJobInfoDAO.savePosition(baseJobInfo));

  }


  @Test
  public void testFindById() {
    String positionId = "L123";
    Assert.assertNotNull(baseJobInfoDAO.findPositionById(positionId));
    positionId = "L1";
    Assert.assertNull(baseJobInfoDAO.findPositionById(positionId));

  }

  @Test
  public void testQueryWithCondition() {
    String city = "上海";
    String keyword = "Java";
    String workYear = "1-3年";

    List<BaseJobInfo> baseJobInfoList =
        baseJobInfoDAO.queryPositionsWithCondition(city, keyword, workYear);

    System.out.println(baseJobInfoList.size());
    Assert.assertNotEquals(0, baseJobInfoList.size());

  }
}