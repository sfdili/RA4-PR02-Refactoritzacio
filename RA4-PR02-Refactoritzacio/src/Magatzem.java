class Magatzem {

    private static final String FORMATGE = "Formatge Gidurat";
    private static final String ENTRADES = "Entrades per al Concert del Trobador";
    private static final String LEGENDARI = "Martell de Thor (Llegendari)";

    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (Article a : articles) {
            actualitzarArticle(a);
        }
    }

    private void actualitzarArticle(Article a) {

        if (a.nom.equals(FORMATGE)) {
            formatge(a);

        } else if (a.nom.equals(ENTRADES)) {
            entrades(a);

        } else if (a.nom.equals(LEGENDARI)) {
            legendari(a);

        } else {
            normal(a);
        }
    }

    private void normal(Article a) {

        if (a.qualitat > 0) {
            a.qualitat--;
        }

        a.diesPerVendre--;

        if (a.diesPerVendre < 0 && a.qualitat > 0) {
            a.qualitat--;
        }
    }

    private void formatge(Article a) {

        if (a.qualitat < 50) {
            a.qualitat++;
        }

        a.diesPerVendre--;

        if (a.diesPerVendre < 0 && a.qualitat < 50) {
            a.qualitat++;
        }
    }

    private void entrades(Article a) {

        if (a.diesPerVendre < 0) {
            a.qualitat = 0;
            return;
        }

        if (a.qualitat < 50) {
            a.qualitat++;

            if (a.diesPerVendre < 11) a.qualitat++;
            if (a.diesPerVendre < 6) a.qualitat++;
        }

        a.diesPerVendre--;
    }

    private void legendari(Article a) {
        // no cambia nada
    }
}