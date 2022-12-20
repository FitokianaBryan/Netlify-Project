package RestController;

import Dao.TokenDao;
import Dao.VehiculeDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/vehicule")
public class VehiculeRestController {

    //liste des vehicules
    @GetMapping("/vehicules")
    public ResponseEntity<ArrayList<HashMap<String, Object>>> liste(@RequestHeader("token") String token, @RequestHeader("role") String role){
        TokenDao td = new TokenDao();
        try{
            if(td.isAdminToken(token,role)==1)
            {
                System.out.println("AUTHORIZED");
                return new ResponseEntity<ArrayList<HashMap<String, Object>>>(new VehiculeDao().liste(), HttpStatus.OK);
            }
            else{
                System.out.println("UNAUTHORIZED");
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //ajout vehicule
    @PostMapping("/ajoutVehicule")
    public ResponseEntity<Boolean> inserere(@RequestParam(name="nomvehicule") String nomvehicule, @RequestParam(name="numero") String numero) throws  Exception{
        VehiculeDao vd = new VehiculeDao();
        vd.insererVehicule(nomvehicule,numero);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //modifier vehicule
    @PutMapping("/updateVehicule/{idvehicule}")
    public ResponseEntity<Boolean> updateVehicule(@PathVariable String idvehicule,@RequestParam(name="nomvehicule") String nomvehicule, @RequestParam(name="numero") String numero) throws  Exception{
        VehiculeDao vd = new VehiculeDao();
        vd.updateVehicule(idvehicule,nomvehicule,numero);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //supprimer vehicule
    @DeleteMapping("/deleteVehicule/{idvehicule}")
    public ResponseEntity<Boolean> deleteVehicule(@PathVariable String idvehicule) throws  Exception{
        VehiculeDao vd = new VehiculeDao();
        vd.deleteVehicule(idvehicule);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
