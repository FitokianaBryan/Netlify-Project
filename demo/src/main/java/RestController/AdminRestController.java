package RestController;

import Dao.AdminDao;
import Dao.TokenDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminRestController {

    //Authentification
    @PostMapping("/login")
    public ResponseEntity login(@RequestParam("users") String users, @RequestParam("mdp") String mdp) throws Exception
    {
        AdminDao ad = new AdminDao();
        TokenDao td = new TokenDao();
        String result = ad.login(users,mdp);
        if(result!=null)
        {
            System.out.println(result);
            td.insertTokenAdmin(result);
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/logout")
    public String logout(@RequestHeader("token") String token,@RequestHeader("idadmin") String idadmin)
    {
        TokenDao td = new TokenDao();
        td.deleteTokenAdmin(token,idadmin);
        return "deconnexion";
    }
}
