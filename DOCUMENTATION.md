<!-- omit from toc -->
# Documentazione del codice per la versione v1.0

<!-- omit from toc -->
## Tabella dei contenuti
- [**Calcolatrice.java**](#calcolatricejava)
  - [`private void appendCharacter(String character)`](#private-void-appendcharacterstring-character)
  - [`private void calculateAndUpdateTextFields(int result_destination, String key_pressed_operator)`](#private-void-calculateandupdatetextfieldsint-result_destination-string-key_pressed_operator)
  - [`private void updateTextFieldsWithResultOnMainDisplay(TextFields TF, Results R)`](#private-void-updatetextfieldswithresultonmaindisplaytextfields-tf-results-r)
  - [`private void updateTextFieldsWithResultOnSecondaryDisplay(TextFields TF, Results R, String key_pressed_operator)`](#private-void-updatetextfieldswithresultonsecondarydisplaytextfields-tf-results-r-string-key_pressed_operator)
  - [`private Results handleOperation(TextFields TF, int result_destination)`](#private-results-handleoperationtextfields-tf-int-result_destination)
  - [`private String parenthesisInator(String str_value)`](#private-string-parenthesisinatorstring-str_value)
  - [`private String deParenthesisInator(String str_value)`](#private-string-deparenthesisinatorstring-str_value)
  - [`private double calculate(String operator, double first_value, double second_value)`](#private-double-calculatestring-operator-double-first_value-double-second_value)
- [**TextFields.java**](#textfieldsjava)
  - [`public TextFields(String main_display_content, String secondary_display_content)`](#public-textfieldsstring-main_display_content-string-secondary_display_content)
- [**Results.java**](#resultsjava)
  - [`public Results(Double textField1_value, Double textField2_value, MiddleOperator OP, Double result)`](#public-resultsdouble-textfield1_value-double-textfield2_value-middleoperator-op-double-result)
- [**MiddleOperator.java**](#middleoperatorjava)
  - [`public MiddleOperator(String str)`](#public-middleoperatorstring-str)
  - [`private void setOperator(String str)`](#private-void-setoperatorstring-str)
  - [`Boolean isOperator()`](#boolean-isoperator)
- [**History.java**](#historyjava)
  - [`public History(String path)`](#public-historystring-path)
  - [`public void saveToBuffer(String record)`](#public-void-savetobufferstring-record)
  - [`public void saveHistoryToFile()`](#public-void-savehistorytofile)
  - [`public void freeResources()`](#public-void-freeresources)

## [**Calcolatrice.java**](src/Calcolatrice.java)

File principale contenente tutto il codice riferito all'interfaccia della calcolatrice, oltre che a quello di logica che gestisce: calcoli, azioni dei pulsanti e aggiornamento dei campi di testo.

| Attributo           | Descrizione                                                                                                                           |
| ------------------- | ------------------------------------------------------------------------------------------------------------------------------------- |
| Boolean after_equal | usato per stabilire se l'operazione corrente sta essendo effettuata dopo che l'utente ha premuto il tasto "uguale" (calcolo ripetuto) |
| History History     | oggetto che si occupa della gestione della cronologia                                                                                 |

> [!IMPORTANT]
> Alcune funzioni presenti in "Calcolatrice.java" sono generate automaticamente da Netbeans e quindi il codice è in continua variazione

> [!NOTE]
> Tutte le funzioni che terminano con `...ActionPerformed()` sono degli handler per vari tasti e funzioni dell'interfaccia 

### `private void appendCharacter(String character)`
- **_Descrizione_**: Si occupa di _appendere_ o meglio dire aggiungere il carattere specificato al campo di testo principale.

- **_Parametri_**: 
    | Parametro        | Descrizione             |
    | ---------------- | ----------------------- |
    | String character | carattere da aggiungere |

- **_Ritorna_**: nulla.

### `private void calculateAndUpdateTextFields(int result_destination, String key_pressed_operator)`
- **_Descrizione_**: Gestisce i campi di testo e la cronologia, nello specifico si occupa di: 
    - _spostare_ i valori dal campo di testo principale a quello secondario;
    - avviare calcoli;
    - mostrare i valori correttamente nei campi di testo (con tanto di parentesi, se necessarie);
    - salvare in cronologia l'ultimo calcolo, se effettuato.

- **_Parametri_**: 
    | Parametro                   | Descrizione                                                                                            |
    | --------------------------- | ------------------------------------------------------------------------------------------------------ |
    | int result_destination      | identificatore campo di testo di destinazione del risultato (0 quello principale, 1 quello secondario) |
    | String key_pressed_operator | operatore selezionato dall'utente (es.: +,-,*,/,%)                                                     |

- **_Ritorna_**: nulla.
  
### `private void updateTextFieldsWithResultOnMainDisplay(TextFields TF, Results R)`
- **_Descrizione_**: Aggiorna i campi di testo _posizionando_ il risultato nel campo di testo principale (ad es.: quando viene premuto "uguale").

- **_Parametri_**: 
    | Parametro     | Descrizione                                                       |
    | ------------- | ----------------------------------------------------------------- |
    | TextFields TF | oggetto dove contenere le stringhe da inserire nei campi di testo |
    | Results R     | oggetto contenente i parametri dei calcoli                        |

- **_Ritorna_**: nulla.


### `private void updateTextFieldsWithResultOnSecondaryDisplay(TextFields TF, Results R, String key_pressed_operator)`
- **_Descrizione_**: Aggiorna i campi di testo _posizionando_ il risultato nel campo di testo secondario (ad es.: quando viene ripetuto un calcolo).

- **_Parametri_**: 
    | Parametro                   | Descrizione                                                       |
    | --------------------------- | ----------------------------------------------------------------- |
    | TextFields TF               | oggetto dove contenere le stringhe da inserire nei campi di testo |
    | Results R                   | oggetto contenente i parametri dei calcoli                        |
    | String key_pressed_operator | operatore selezionato dall'utente (es.: +,-,*,/,%)                |

- **_Ritorna_**: nulla.

### `private Results handleOperation(TextFields TF, int result_destination)`
- **_Descrizione_**: Si occupa di gestire il l'operazione, e quindi:
    - rimuovere le parentesi se presenti, in modo da poter estrarre il valore;
    - stabilire cosa mettere nel display primario e cosa in quello secondario;
    - avviare il calcolo effettivo.

- **_Parametri_**: 
    | Parametro              | Descrizione                                                                                            |
    | ---------------------- | ------------------------------------------------------------------------------------------------------ |
    | TextFields TF          | oggetto dove contenere le stringhe da inserire nei campi di testo                                      |
    | int result_destination | identificatore campo di testo di destinazione del risultato (0 quello principale, 1 quello secondario) |

- **_Ritorna_**: oggetto contenente i parametri dei calcoli

### `private String parenthesisInator(String str_value)`
- **_Descrizione_**: Si occupa di _contenere_ un valore tra parentesi se negativo.

- **_Parametri_**: 
    | Parametro        | Descrizione           |
    | ---------------- | --------------------- |
    | String str_value | valore da controllare |

- **_Ritorna_**: stringa aggiornata con valore tra parentesi se negativo.

### `private String deParenthesisInator(String str_value)`
- **_Descrizione_**: Si occupa di rimuovere le parentesi ad un valore _contenuto_ tra di esse se presenti.

- **_Parametri_**: 
    | Parametro        | Descrizione           |
    | ---------------- | --------------------- |
    | String str_value | valore da controllare |

- **_Ritorna_**: stringa aggiornata con valore senza parentesi.

### `private double calculate(String operator, double first_value, double second_value)`
- **_Descrizione_**: Si occupa di gestire i calcoli.

- **_Parametri_**: 
    | Parametro           | Descrizione                                                            |
    | ------------------- | ---------------------------------------------------------------------- |
    | String operator     | contiene l'operatore selezionato dall'utente per l'operazione seguente |
    | double first_value  | primo valore                                                           |
    | double second_value | secondo valore                                                         |

- **_Ritorna_**: il risultato del calcolo.

## [**TextFields.java**](src/TextFields.java)

Classe contenente due attributi che permettono di conservare le stringhe da inserire nei campi di testo.

| Attributo                        | Descrizione                                                                      |
| -------------------------------- | -------------------------------------------------------------------------------- |
| String main_display_content      | contiene la stringa da inserire nel campo di testo principale (quello inferiore) |
| String secondary_display_content | contiene la stringa da inserire nel campo di testo secondario (quello superiore) |

### `public TextFields(String main_display_content, String secondary_display_content)`
- **_Descrizione_**: Costruttore che inizializza l'oggetto con i parametri forniti.

- **_Parametri_**: 
    | Parametro                        | Descrizione                                                                      |
    | -------------------------------- | -------------------------------------------------------------------------------- |
    | String main_display_content      | contiene la stringa da inserire nel campo di testo principale (quello inferiore) |
    | String secondary_display_content | contiene la stringa da inserire nel campo di testo secondario (quello superiore) |

- **_Ritorna_**: nulla.

## [**Results.java**](src/Results.java)

Classe contenente degli attributi che permettono di conservare tutti i parametri necessari per effettuare i calcoli.

| Attributo           | Descrizione                                                            |
| ------------------- | ---------------------------------------------------------------------- |
| String first_value  | primo valore                                                           |
| String second_value | secondo valore                                                         |
| MiddleOperator OP   | contiene l'operatore selezionato dall'utente per l'operazione seguente |
| String result       | risultato dell'operazione                                              |

### `public Results(Double textField1_value, Double textField2_value, MiddleOperator OP, Double result)`
- **_Descrizione_**: Costruttore che inizializza l'oggetto con i parametri forniti.

- **_Parametri_**: 
    | Parametro           | Descrizione                                                            |
    | ------------------- | ---------------------------------------------------------------------- |
    | String first_value  | primo valore                                                           |
    | String second_value | secondo valore                                                         |
    | MiddleOperator OP   | contiene l'operatore selezionato dall'utente per l'operazione seguente |
    | String result       | risultato dell'operazione                                              |

- **_Ritorna_**: nulla.

## [**MiddleOperator.java**](src/MiddleOperator.java)

Classe che si occupa di gestire l'operatore selezionato dall'utente per l'operazione seguente.

| Attributo                    | Descrizione                                                            |
| ---------------------------- | ---------------------------------------------------------------------- |
| String middle_operator       | contiene l'operatore selezionato dall'utente per l'operazione seguente |
| int middle_operator_position | contiene l'indice della posizione dell'operatore nella stringa data    |

### `public MiddleOperator(String str)`
- **_Descrizione_**: Costruttore che prende in input una stringa per poi passarla al metodo che si occuperà di estrarre l'operatore da essa.

- **_Parametri_**: 
    | Parametro                    | Descrizione                                                            |
    | ---------------------------- | ---------------------------------------------------------------------- |
    | String middle_operator       | contiene l'operatore selezionato dall'utente per l'operazione seguente |
    | int middle_operator_position | contiene l'indice della posizione dell'operatore nella stringa data    |

- **_Ritorna_**: nulla.

### `private void setOperator(String str)`
- **_Descrizione_**: Data una stringa contenente l'operatore selezionato dall'utente, questo metodo lo copia in `String middle_operator`.

- **_Parametri_**: 
    | Parametro  | Descrizione                                                                     |
    | ---------- | ------------------------------------------------------------------------------- |
    | String str | striga contenente l'operatore selezionato dall'utente per l'operazione seguente |

- **_Ritorna_**: nulla.

### `Boolean isOperator()`
- **_Descrizione_**: Determina se il carattere contenuto in `String middle_operator` è un operatore.

- **_Parametri_**: nessuno.

- **_Ritorna_**: `true` se il carattere contenuto in `String middle_operator` è un operatore, altrimenti `false`.

## [**History.java**](src/History.java)

Classe che si occupa della gestione della cronologia dei calcoli.

| Attributo                 | Descrizione                                                             |
| ------------------------- | ----------------------------------------------------------------------- |
| File output_file          | oggetto che fa riferimento al file dove la cronologia sarà salvata      |
| FileOutputStream out_byte | oggetto che scrive byte sul file                                        |
| PrintWriter out_line      | oggetto che scrive i calcoli in un buffer per poi passarli a `out_byte` |
| int current_record_ID     | variabile che incrementa con il numero di calcoli effettuati            |

### `public History(String path)`
- **_Descrizione_**: Costruttore che prende in input il percorso del file della cronologia che andrà creato, si occupa inoltre di inizializzare tutti gli oggetti necessari per la scrittura su file.

- **_Parametri_**: 
    | Parametro   | Descrizione                                         |
    | ----------- | --------------------------------------------------- |
    | String path | percorso del file della cronologia che andrà creato |

- **_Ritorna_**: nulla.

### `public void saveToBuffer(String record)`
- **_Descrizione_**: Permette di salvare sul buffer il calcolo corrente.

- **_Parametri_**: 
    | Parametro     | Descrizione                              |
    | ------------- | ---------------------------------------- |
    | String record | stringa contenente il calcolo effettuato |

- **_Ritorna_**: nulla.

### `public void saveHistoryToFile()`
- **_Descrizione_**: Salva la cronologia dei calcoli effettuati sul file svuotando il buffer.

- **_Parametri_**: nessuno.

- **_Ritorna_**: nulla.

### `public void freeResources()`
- **_Descrizione_**: Rilascia il file.

- **_Parametri_**: nessuno.

- **_Ritorna_**: nulla.
