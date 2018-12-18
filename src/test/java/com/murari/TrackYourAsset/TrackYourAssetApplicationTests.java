package com.murari.TrackYourAsset;

import com.murari.TrackYourAsset.Repository.UserProfileRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrackYourAssetApplicationTests {

	@Autowired
	protected UserProfileRepository userProfileRepository;

/*	@Before
	public void deleteAll(){*/
//		try{
			//userProfileRepository.deleteAll();

	/*	} catch (Exception e){
			System.out.println("ERROR:"+e.getMessage());
		}*/
	//}

	@Test
	public void contextLoads() {
	}

}
