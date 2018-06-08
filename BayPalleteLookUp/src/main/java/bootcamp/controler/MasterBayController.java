package bootcamp.controler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bootcamp.model.MasterBay;
import bootcamp.service.MasterBayService;

@RestController
public class MasterBayController {
	
	@Autowired
	MasterBayService masterBayService;
	
	//do we need this???
  @RequestMapping("/getMasterBayList")
  public List<MasterBay> getMasterBayList() {
  	return masterBayService.getMasterBayList();
  }
  
  //given masterbay ID return a masterbay object with it's dimentions and all the subbays listed.
  @RequestMapping(value = "/getMasterbayById", method = RequestMethod.GET   )
  public MasterBay getMasterbayById(@RequestParam("id") int id) {
	  return masterBayService.getMasterbayById(id);
  }
  
  @RequestMapping(value = "/addMasterBay", method=RequestMethod.POST)
  public void addMasterBay(@RequestBody MasterBay masterBay) {
	  masterBayService.addMasterBay(masterBay);
  }
  
  @RequestMapping(value = "/deleteMasterBay", method=RequestMethod.POST)
  public void deleteMasterBay(@RequestParam("id") String id) {
	  masterBayService.deleteMasterBay(id);
  }
  
  @RequestMapping(value = "/editMasterBay",method= RequestMethod.POST)
  public void editMasterBay(@RequestBody MasterBay masterBay) {
	  masterBayService.editMasterBay(masterBay);
  }

}
