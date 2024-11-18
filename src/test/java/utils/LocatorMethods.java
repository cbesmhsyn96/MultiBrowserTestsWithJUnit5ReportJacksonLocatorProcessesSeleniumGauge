package utils;

import base.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LocatorMethods extends ChromeBase {
    private static String dir = "src/test/resources";
    private static File file = new File(dir);
    private static List<File> files = Arrays.asList(Objects.requireNonNull(file.listFiles()));
    private static List<File> jsonFiles = files.stream().filter(file1 -> file1.toString().endsWith(".json")).collect(Collectors.toList());
    private static ObjectMapper objectMapper;

    protected static JsonNode getNodeOfSearchedKey(String searchedKey) throws IOException {
        objectMapper = new ObjectMapper();
        for (File currentFile : jsonFiles){
            JsonNode jsonNodes = objectMapper.readTree(currentFile);
            for (JsonNode currentNode : jsonNodes){
                if (currentNode.get("key").asText().contains(searchedKey)){
                   return currentNode;
                }
            }
        }
        return null;
    }

    protected static WebElement findElement(String searchedKey) throws IOException {
        String value = Objects.requireNonNull(getNodeOfSearchedKey(searchedKey)).get("value").asText();
        String type = Objects.requireNonNull(getNodeOfSearchedKey(searchedKey)).get("type").asText();
        switch (type){
            case "css": return driver.findElement(By.cssSelector(value));
            case "xpath": return driver.findElement(By.xpath(value));
            case "id": return driver.findElement(By.id(value));
            case "class": return driver.findElement(By.className(value));
            case "name": return driver.findElement(By.name(value));
            case "linktext": return driver.findElement(By.linkText(value));
        }
        return null;
    }

}