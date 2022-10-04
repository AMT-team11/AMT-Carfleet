package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import main.Car;
import main.ParserJSON;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCar {

    ParserJSON parser = new ParserJSON();
    @BeforeEach
    void setUp() {
        parser = new ParserJSON();
    }
    /* test that the parser throw an exception if it receives an empty file */
    @Test
    public void emptyFileTest(){

        File file = new File("empty.json");
        assertThrows(ParserJSON.EmptyJSONException.class, () -> parser.parse(file));
    }

    @Test
    public void Jackson() throws Exception {
        String json = "{\n" +
                "  \"data\": {\n" +
                "    \"boards\": [\n" +
                "      {\n" +
                "        \"items\": [\n" +
                "          {\n" +
                "            \"id\": \"939948275\",\n" +
                "            \"name\": \"GE 123201\",\n" +
                "            \"column_values\": [\n" +
                "              {\n" +
                "                \"title\": \"Modèle\",\n" +
                "                \"text\": \"Volkswagen California\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Sous-éléments\",\n" +
                "                \"text\": \"Coordonnées du chauffeur\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Nom/prénom\",\n" +
                "                \"text\": \"Schmidt Alain\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Numéro de véhicule interne entreprise\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Numéro de châssis\",\n" +
                "                \"text\": \"WV1 ZZZ 2KZ KY0 417 46\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Code carte carburant /carte\",\n" +
                "                \"text\": \"12\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Service inclus\",\n" +
                "                \"text\": \"Non\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Garantie\",\n" +
                "                \"text\": \"assurance garantie Amag/Zurich jusqu'à 200'000km / 12.23\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Propriétaire\",\n" +
                "                \"text\": \"Raiffeisen\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"1er mise en circulation\",\n" +
                "                \"text\": \"2018-12-04\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Km actuel\",\n" +
                "                \"text\": \"104626\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Date dernier check-up\",\n" +
                "                \"text\": \"2022-03-31\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Statut état du VHC\",\n" +
                "                \"text\": \"Ok rien à faire\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Remarques, à faire\",\n" +
                "                \"text\": \"En ordre\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Notes générales sur le véhicule (ne pas faire)\",\n" +
                "                \"text\": \"Véhicule fumeur et peu soigné, divers traces carrosserie et dégât av. dr.\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Document en cours\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Garage référence\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Début du rdv\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Fin du rdv\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Rendez-vous prévu chez\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Google Calendar event\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Échéances à traiter\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Pneus montés\",\n" +
                "                \"text\": \"pneus été\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Dimension été\",\n" +
                "                \"text\": \"195/65 R15 91T\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Dimension hiver\",\n" +
                "                \"text\": \"195/65 R15 95T  195/65 R15 91T\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Localisation des pneus\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Nom assurance\",\n" +
                "                \"text\": \"Vaudoise\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Couverture assurance + franchise\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Police d'assurance\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Assistance\",\n" +
                "                \"text\": null\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Prochain service km\",\n" +
                "                \"text\": \"114000\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Km restant jusqu'au service\",\n" +
                "                \"text\": \"\"\n" +
                "              },\n" +
                "              {\n" +
                "                \"title\": \"Date du prochain service\",\n" +
                "                \"text\": \"2023-09-26\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"account_id\": 7650323\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.readValue(json, ObjectNode.class);
        System.out.println(node.get("data").get("boards").get(0));
    }
}
