import Model.Client;
import Model.Curier;
import Model.Livrare;
import Repositories.ClientRepository;
import Repositories.CurierRepository;
import Repositories.LivrareRepository;

public class Main {

    public static void main(String[] args) {
      Livrare livrare=new Livrare("6,6,2005,11,11",new Client("marin","mar"),new Curier("aa","bb"),false,false);
        LivrareRepository livrareRepository=new LivrareRepository();
        System.out.println(livrareRepository.allLivrari());
    }

}
