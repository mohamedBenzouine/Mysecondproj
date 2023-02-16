public class Cinema extends Entreprise implements CineInfo {

    private int idCinema;

    public Cinema(int idCinema,String nom, String adresse) {
        super(nom, adresse);
        this.idCinema = idCinema;
    }


    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "idCinema:" + this.idCinema +","+ "Nom:"+ super.getNom() +"Adresse:" +super.getAdresse()+
                '}';
    }


    @Override
    public void Afficheinfo() {
        System.out.println(toString());
    }
}
