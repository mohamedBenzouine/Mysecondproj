public class Film {

    private int idFilm;
    private int idRealisateur;
    private String titre;
    private String genre;
    private int annee;


    public Film() {}

    public Film(int idFilm, int idRealisateur, String titre, String genre, int annee) {
        this.idFilm = idFilm;
        this.idRealisateur = idRealisateur;
        this.titre = titre;
        this.genre = genre;
        this.annee = annee;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getIdRealisateur() {
        return idRealisateur;
    }

    public void setIdRealisateur(int idRealisateur) {
        this.idRealisateur = idRealisateur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", idRealisateur=" + idRealisateur +
                ", titre='" + titre + '\'' +
                ", genre='" + genre + '\'' +
                ", annee=" + annee +
                '}';
    }

    public boolean equals(Film f){
        if (this.idFilm == f.idFilm) return true;
        else return false;
        }

}
