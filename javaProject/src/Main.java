import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {

        // Création d'arrayList listePerso <Personne> et 2 objets

        ArrayList<Personne> listePerso = new ArrayList<>();

        Personne p1 = new Personne(30,"Mohamed","benzouine");
        Personne p2 = new Personne(31,"David", "Martial");

        listePerso.add(p1);
        listePerso.add(p2);

        System.out.println("Liste des personnes :");
        for (Personne p : listePerso) {
            System.out.println(p.toString());

        }



        //System.out.println(p1.toString());
        //System.out.println(p2.toString());

        // Création d'arrayList listeFilm <Film> et 2 objets

        ArrayList<Film> listeFilm = new ArrayList<>();

        Film f1 = new Film(18,22,"Spiderman","Hero",2008);
        Film f2 = new Film(19,23,"Batman","Hero",1991);

        listeFilm.add(f1);
        listeFilm.add(f2);

        // Création d'arrayList listeCinema <Cinéma> et 2 objets

        ArrayList<Cinema> listeCinema = new ArrayList<>();

        Cinema c1 = new Cinema(19,"Megarama","casa");
        Cinema c2 = new Cinema(18,"Pathé","paris");

        listeCinema.add(c1);
        listeCinema.add(c2);


        System.out.println("Liste des Cinema :");
        for (Cinema c : listeCinema) {
            System.out.println(c.toString());
        }

        /*Scanner sc = new Scanner(System.in);
        for(int i =0; i<2; i++){
            System.out.println("Création d'un cinéma:");

            System.out.println("ID: ");
            int idCinema = sc.nextInt();

            System.out.println("Nom: ");
            String nom = sc.nextLine();

            System.out.println("Adresse: ");
            String adresse = sc.nextLine();

            Cinema c = new Cinema(idCinema,nom,adresse);
            listeCinema.add(c);
        }
         */


        try{
            // Connexion à la base de données
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinebase1","root","");

            System.out.println("La BDD est connencté");

            // Affichage des personnes dont le nom commence par la lettre « S ».
            Statement st1 = c.createStatement();
            System.out.println("==================================");
            String myQuery1 = "SELECT * FROM personne WHERE nom LIKE \"s%\"";
            ResultSet resultSet1 = st1.executeQuery(myQuery1);

            while (resultSet1.next()){
                System.out.println(resultSet1.getInt(1)+ "|" + resultSet1.getString("nom")+ "|" + resultSet1.getString("prenom"));
            }


            // Affichage des films dont le titre contient le mot « blanc ».
            Statement st2 = c.createStatement();
            System.out.println("==================================");
            String myQuery2 = "SELECT * FROM film WHERE titre LIKE \"%blanc%\";\n";
            ResultSet resultSet2 = st1.executeQuery(myQuery2);

            while (resultSet2.next()){
                System.out.println(resultSet2.getInt(1)+ "|" + resultSet2.getString("titre"));
            }
            //Ajout des objets dans la liste listeCinema dans la table Cinéma dans la base de données.
            // Ici on va utiliser PreparedStatement parceque on va ajouter des variables
            System.out.println("==================================");

            Cinema tempCinema = listeCinema.get(0);
            String myQuery3 = "INSERT INTO cinema VALUES(?,?,?)";

            PreparedStatement ps1 = c.prepareStatement(myQuery3);

            ps1.setInt(1,tempCinema.getIdCinema());
            ps1.setString(2,tempCinema.getNom());
            ps1.setString(3,tempCinema.getAdresse());

            int res = ps1.executeUpdate();

            System.out.println(res);

            System.out.println("==================================");

            //Demander à l’utilisateur d’entrer un entier (idCinema) et un nouveau nom.
            // Modifier le nom du cinéma ayant l’idCinema entré par l’utilisateur.
            /*

            Scanner sc = new Scanner(System.in);

            int idCinemaTemp;
            String NomCinemaTemp;

            idCinemaTemp = sc.nextInt();
            NomCinemaTemp = sc.next();


            String r5 = " UPDATE cinema SET nom = ? WHERE idCinema= ? ";
            PreparedStatement ps3 = c.prepareStatement(r5);

            ps3.setString(1,NomCinemaTemp);
            ps3.setInt(2,idCinemaTemp);


            int res3 = ps3.executeUpdate();
            System.out.println(res3);

            System.out.println("==================================");

             */

            //Supprimer les projections pour l’idFilm = 3

            String r6 = "DELETE FROM projection WHERE idFilm=?";
            PreparedStatement ps4 = c.prepareStatement(r6);

            int idC = 10;
            ps4.setInt(1, idC);
            int res4 = ps4.executeUpdate();
            System.out.println(res4);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}