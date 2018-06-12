package bootcamp.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bootcamp.model.DimensionMatch;
import bootcamp.model.Palette;
import bootcamp.service.PaletteService;

@RestController
public class PaletteController {
	
	@Autowired
	PaletteService paletteService;
	
	@CrossOrigin
    @RequestMapping(value = "/addPalette", method = RequestMethod.POST)
    public void addPalette(@RequestBody Palette palette) {
    	paletteService.addPalette(palette);
    }
	
	@CrossOrigin
    @RequestMapping(value ="/getPaletteById", method = RequestMethod.GET)
    public Palette getPaletteById(@RequestParam("id") int id) {
    	return paletteService.getPaletteById(id);
    }
    
	@CrossOrigin
    @RequestMapping(value ="/editPalette", method = RequestMethod.POST)
    public DimensionMatch editPalette(@RequestBody Palette palette) {
    	return paletteService.editPalette(palette);
    }
    
	@CrossOrigin
    @RequestMapping(value ="/deletePalette", method = RequestMethod.DELETE) 
    public void deletePalette(@RequestParam("id") int id) {
    	paletteService.deletePalette(id);
    }
    
    @RequestMapping(value = "/unlinkPalette", method = RequestMethod.GET)
    public void unlinkPalette(@RequestParam("id") int id) {
    	paletteService.unlinkPalette(id);
    }
    
    //sample palette object json:
    // {"id": "1", "width": 34, "height": 34, "length": 34, "dep": "D1", "paletteClass": "C1", "category": "CAT1", "bay": "1"}
    
}
