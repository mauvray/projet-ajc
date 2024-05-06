package grp1.malveillancemax.dto.responses;

public class JsonViews {

    public static class Generic{}

    public static class Alcool extends Generic{}

    public static class AlcoolAvecCocktail extends Alcool{}

    public static class Soft extends Generic{}

    public static class SoftAvecCocktail extends Soft{}

    public static class Cocktail extends Generic{}

    public static class CocktailAvecAlcool extends Cocktail{}

    public static class CocktailAvecSoft extends Cocktail{}

}
