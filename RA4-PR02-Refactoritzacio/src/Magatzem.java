class Magatzem {

    private static final String FORMATGE = "Formatge Gidurat";
    private static final String ENTRADES = "Entrades per al Concert del Trobador";
    private static final String LEGENDARI = "Martell de Thor (Llegendari)";

    Article[] articles;

    public Magatzem(Article[] articles) {
        this.articles = articles;
    }

    public void actualitzarEstat() {
        for (int i = 0; i < articles.length; i++) {
            actualitzarArticle(articles[i]);
        }
    }

    private void actualitzarArticle(Article a) {

        if (!a.nom.equals(FORMATGE)
                && !a.nom.equals(ENTRADES)) {

            if (a.qualitat > 0) {

                if (!a.nom.equals(LEGENDARI)) {
                    a.qualitat--;
                }
            }

        } else {

            if (a.qualitat < 50) {
                a.qualitat++;

                if (a.nom.equals(ENTRADES)) {

                    if (a.diesPerVendre < 11) {
                        if (a.qualitat < 50) {
                            a.qualitat++;
                        }
                    }

                    if (a.diesPerVendre < 6) {
                        if (a.qualitat < 50) {
                            a.qualitat++;
                        }
                    }
                }
            }
        }

        if (!a.nom.equals(LEGENDARI)) {
            a.diesPerVendre--;
        }

        if (a.diesPerVendre < 0) {

            if (!a.nom.equals(FORMATGE)) {

                if (!a.nom.equals(ENTRADES)) {

                    if (a.qualitat > 0) {

                        if (!a.nom.equals(LEGENDARI)) {
                            a.qualitat--;
                        }
                    }

                } else {
                    a.qualitat = 0;
                }

            } else {
                if (a.qualitat < 50) {
                    a.qualitat++;
                }
            }
        }
    }
}