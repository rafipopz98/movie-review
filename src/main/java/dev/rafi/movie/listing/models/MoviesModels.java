package dev.rafi.movie.listing.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movieDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviesModels {

    @Id
    private ObjectId id;
    private String title;
    private  String desc;
    private String movieImg;
    private List<String> genres;
    @DocumentReference
    private List<Reviews> reviewIds;


}
