# Kuama Backend Developer Test

Given the following [api specs](https://www.thecocktaildb.com/api.php)

Create a restful API that will show

- [ ] all drinks categories
- [ ] all drinks of type shot
- [ ] all drinks that give a results for the keyword `spritz`.

For each drink, we want to know the following information:

- name
- glass
- instructions
- ingredients
- thumbnail

The keys of the json objects returned by your API should all be in camel case format

Create the API using any language and framework you prefer.

If short on time, at least write down a list of todos with what you think is missing.

## Bonus points

This is not a list to be followed top-bottom, just some enhancements you can do to show off 🙌 🚀

- [ ] Add a suite of tests
- [ ] Store results inside a persistence layer
- [ ] Setup a github action while making your PR to this repository

## How to deliver

If you know how: clone this repository, create a separate branch and make a PR

Otherwise: send us a zip with your project

## What will be rated?

- Code readability
- How you structure your project
- WTFs/minute

Remember: **it is not a problem if you don't complete your test**, as long as you keep our WTFs/minutes at a minimum rate.

And remember:

![programmer](https://raw.githubusercontent.com/Kuama-IT/kuama-frontend-test/master/programmer.png)

Have fun!

With ♥️ from Kuama folks

# Realizzazione test

## Disclaimer

Inizialmente, a causa di una mia svista, non avevo inteso che l'esercizio verteva esclusivamente sulla realizzazione del backend, dovendo quindi tralasciare la realizzazione di un db; a questo proposito, la mia soluzione propone sia una versione che permette all'utente di interfacciarsi, tramite l'utilizzo di uno swagger, sia al db proposto all'interno della consegna sia ad una versione ridotta di un db realizzato ad hoc all'interno di un db postgres (anch'esso dockerizzato).

## Bootstrap dell'applicativo

Il progetto necessita, come prima cosa, di un file .env da dover creare dentro la root di progetto e cosi strutturato

```
DRINKS_POSTGRES_DB=
DRINKS_POSTGRES_USER=
DRINKS_POSTGRES_PASSWORD=
DRINKS_POSTGRES_PORT=

DRINKS_PG_CONTAINER_NAME=
DRINKS_BACKEND_CONTAINER_NAME=
```

Anche se di norma va evitato il versionamento dei file .env, per questioni di sicurezza, ho deciso di mantenere versionata una copia del file .env utilizzata in fase di sviluppo del test.

Se si vuol poter usare anche le route censite come "drinks-docker", è necessario aver installato sulla propria macchina Docker e Docker-compose di cui rimando al seguente link per il processo di installazione:
https://docs.docker.com/engine/install/

Una volta terminata correttamente la procedura di installazione ed aver correttamente creato il file .env, sarà sufficiente lanciare direttamente dalla root di progetto il seguente comando

```
docker-compose up
```

Dopo aver controllato che entrambi i container si siano avviati (backend-test**drinks-backend e backend-test**drinks-postgres) sarà sufficiente visitare il link http://localhost:3001/api per consumare le API attraverso lo swagger integrato.

Nel caso in cui si voglia utilizzare solo ed esclusivamente le route definite come "drinks-remote" sarà sufficiente lanciare i seguenti comandi da dentro la directory "be"

```
npm install
npm start
```

## Parametri accettati dalle rotte censite

```
/api/drinks-remote/categories
```

Non accetta alcun tipo di parametro

```
/api/drinks-remote/drinks/{filterType}/{filter}
```

- { filterType }: Il tipo di filtro, sottoforma di stringa, che vogliamo utilizzare; accetta i valori "c" e "n".
- { filter }: Il valore del filtro che si sta cercando di applicare.

```
/api/drinks-docker/categories
```

Non accetta alcun tipo di parametro

```
/api/drinks-docker/drinks/{filterType}/{filter}
```

- { filterType }: Il tipo di filtro, sottoforma di stringa, che vogliamo utilizzare; accetta i valori "c" e "n".
- { filter }: Il valore del filtro che si sta cercando di applicare.
