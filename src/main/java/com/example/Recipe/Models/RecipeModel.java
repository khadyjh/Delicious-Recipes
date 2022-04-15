package com.example.Recipe.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({"userFavRecipe"})
@Entity
public class RecipeModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "recipe_id")
        private int recipe_id;

        private int id;
        @Column(nullable = false)
        private String recipeName;
        @Column(columnDefinition = "TEXT")
        private String description;
        @Column(length = 5000)
        private String thumbnail_url; // image
        @Column(length = 5000)

        @OneToMany(mappedBy = "recipeModelComments", cascade = CascadeType.ALL )
        List<Comment> comments;

        @ManyToOne
        UserApp userOwnRecipe;

        @ManyToOne
        UserApp userFavRecipe;

        @OneToMany(mappedBy = "recipes_ingredient" ,cascade = CascadeType.ALL)
        Set<Ingredient> ingredientModels;

        @OneToMany(mappedBy = "recipes_instruction",cascade = CascadeType.ALL)
        Set<InstructionModel> instructionModels;
            public RecipeModel() {
            }


    public RecipeModel(String name, String  description, String thumbnail_url ) {
                this.recipeName = name;
                this.description = description;
                this.thumbnail_url = thumbnail_url;
        }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String name) {
        this.recipeName = name;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public UserApp getUserOwnRecipe() {
        return userOwnRecipe;
    }

    public void setUserOwnRecipe(UserApp userOwnRecipe) {
        this.userOwnRecipe = userOwnRecipe;
    }

    public UserApp getUserFavRecipe() {
        return userFavRecipe;
    }

    public void setUserFavRecipe(UserApp userFavRecipe) {
        this.userFavRecipe = userFavRecipe;
    }

    public int getRecipe_id() {
                return recipe_id;
        }




    public Set<Ingredient> getIngredientModels() {
        return ingredientModels;
    }

    public void setIngredientModels(Set<Ingredient> ingredientModels) {
        this.ingredientModels = ingredientModels;
    }

    public Set<InstructionModel> getInstructionModels() {
        return instructionModels;
    }

    public void setInstructionModels(Set<InstructionModel> instructionModels) {
        this.instructionModels = instructionModels;
    }

    @Override
        public String toString() {
                return "Recipe{" +
                        "id=" + recipe_id +
                        ", name='" + recipeName + '\'' +
                        ", description='" + description + '\'' +
                        ", thumbnail_url='" + thumbnail_url + '\'' +
//                        ", original_video_url='" + original_video_url + '\'' +
//                        ", instructions=" + instructions +
//                        ", sections=" + sections +
//                        ", comments=" + comments +
//                        ", userOwnRecipe=" + userOwnRecipe +
                        ", userFavRecipe=" + userFavRecipe +
                        '}';
        }
}
