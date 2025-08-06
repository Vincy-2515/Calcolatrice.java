# Documentazione del codice per la versione v1.0

## [Calcolatrice.java](src/Calcolatrice.java)

> [!IMPORTANT]
> Alcune funzioni presenti in questo file sono generate automaticamente da Netbeans e quindi il codice è in continua variazione

> [!NOTE]
> Tutte le funzioni che terminano con `ActionPerformed()` sono degli handler per vari tasti e funzioni dell'interfaccia 

### private void appendCharacter(String character)
- **_Descrizione_**: Si occupa di _appendere_ o meglio dire aggiungere il carattere specificato al campo di testo principale.

- **_Parametri_**: 
    | Parametro | Descrizione             |
    | --------- | ----------------------- |
    | character | carattere da aggiungere |

- **Ritorna**: nulla

### private void calculateAndUpdateTextFields(int result_destination, String key_pressed_operator)
- **_Descrizione_**: Gestisce i campi di testo e la cronologia, nello specifico si occupa di: 
  - _spostare_ i valori dal campo di testo principale a quello secondario;
  - avviare calcoli;
  - mostrare i valori correttamente nei campi di testo (con tanto di parentesi, se necessarie);
  - salvare in cronologia l'ultimo calcolo, se effettuato.

- **_Parametri_**: 
    | Parametro                   | Descrizione                                                                                            |
    | --------------------------- | ------------------------------------------------------------------------------------------------------ |
    | int result_destination      | identificatore campo di testo di destinazione del risultato (0 quello principale, 1 quello secondario) |
    | String key_pressed_operator | operatore selezionato (es.: +,-,*,/,%)                                                                 |

- **Ritorna**: nulla
  
### ---()
- **_Descrizione_**: ---

- **_Parametri_**: 
    | Parametro | Descrizione |
    | --------- | ----------- |

- **Ritorna**: ---

