<main>
    <h1><?= $strTitulo ?></h1>
    <section>
        <p><?= $strTexto ?></p>
        <form action="index.php" method="get">
            <button type="submit">Vuelve a visitar la página</button>
            <button type="submit" name="reinicio">Reiniciar el contador</button>
        </form>
    </section>
</main>