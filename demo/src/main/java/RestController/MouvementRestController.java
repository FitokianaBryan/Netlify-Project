package RestController;

import Dao.MouvementDao;
import Dao.TokenDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/mouvement")
public class MouvementRestController {


    //liste des mouvements
    @GetMapping("/mouvements")
    public ResponseEntity<ArrayList<HashMap<String, Object>>> lister(@RequestHeader("token") String token){
        TokenDao tk = new TokenDao();
        try{
            if(tk.validTokenAdmin(token)==1)
            {
                System.out.println("Delai Non Expiré");
                return new ResponseEntity<ArrayList<HashMap<String, Object>>>(new MouvementDao().liste(), HttpStatus.OK);
            }
            else {
                System.out.println("Delai Expiré");
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //ajout kilometrage
    @PostMapping("/ajoutMouvement")
    public ResponseEntity<Boolean> inserer(@RequestParam(name="idvehicule") String idvehicule,@RequestParam(name="datemouvement") String dateMouvement,@RequestParam(name="departkm") int departkm,@RequestParam(name="arriveekm") int arriveekm) throws  Exception{
        MouvementDao md = new MouvementDao();
        md.insererMouvement(idvehicule,dateMouvement,departkm,arriveekm);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //modifier Mouvement
    @PutMapping("/updateMouvement/{idvehicule}")
    public ResponseEntity<Boolean> updateMouvement(@PathVariable String idvehicule,@RequestParam(name="dateMouvement") String dateMouvement, @RequestParam(name="departkm") int departkm,@RequestParam(name="arriveekm") int arriveekm) throws  Exception{
        MouvementDao md = new MouvementDao();
        md.updateMouvement(idvehicule,dateMouvement,departkm,arriveekm);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //supprimer Mouvement
    @DeleteMapping("/deleteMouvement/{idvehicule}")
    public ResponseEntity<Boolean> deleteMouvement(@PathVariable String idvehicule) throws  Exception{
        MouvementDao md = new MouvementDao();
        md.deleteMouvement(idvehicule);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
