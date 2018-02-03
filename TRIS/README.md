# TRIS(Tic Tac Toe) - AndroidStudioProject
Il **TRIS** prevede che ogni giocatore abbia un **proprio colore**, estratto in modo **casuale** tra **9 colori**. Ho quindi sostituito i classici 'X' e 'O' con i colori.
# Modalità di gioco:
- modalità **player contro player**, 
- modalità **player contro computer**.
# Dettagli progetto:
- Gestione **modalità landscape**, in cui:
	1. vengono **mantenute le mosse correnti**,
	2. vengono **mantenuti i colori delle mosse correnti**,
	3. vengono **aggiornati i flag e variabili necessarie al proseguimento della partita**,
	4. il metodo **rebuild**, si occupa di riportare la situazione **esattamente** come era prima della creazione dell' attività di **landscape**.
- Utilizzo di **splash screen** di **3** secondi, in cui:
	1. viene visualizzato un **logo** preso da questo sito: [iconfinder.com](https://www.iconfinder.com/),
	2. viene visualizzata una **semplice scritta di riconoscimento**,
	3. viene **automaticamente adattato il layout di splash ad un' eventuale modalità di landscape**.
- **Intelligenza artificiale** che opera nel seguente modo:
	1. **controlla per primo le mosse che portano alla vittoria**,
	2. **controlla poi le mosse per impedire la vittoria del player**,
	3. **altrimenti fa una mossa di default o va ad impedire certi casi speciali che porterebbero alla vittoria sicura del player**.
	4. **risposta istantanea**, senza attesa di tempo;
	5. che sia una mossa per **vincere**, o che sia una mossa per **difendere**, vengono controllate in ordine:
		- **righe**,
		- **colonne**,
		- **diagonali**,
		- **mosse di default & casi speciali**.
- Utilizzo di **9 buttons personalizzati**, con:
	1. **8 pixel di bordo nero**,
	2. **angoli arrotondati (radius = 80)**.
- Utilizzo icona personalizzata per l' applicazione, creata sul seguente sito: [AndroidAssetStudio](https://romannurik.github.io/AndroidAssetStudio/).