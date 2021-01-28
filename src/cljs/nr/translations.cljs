(ns nr.translations
  (:require
    [clojure.string :refer [lower-case replace]]
    [nr.appstate :refer [app-state]]
    [taoensso.tempura :as tempura]))

(def translation-dictionary
  {
   :en 
   {:missing ":en missing text"
    :side
    {:corp "Corp"
     :runner "Runner"
     :any-side "Any Side"
     :all "All"}
    :faction
    {:all "All"
     :any-faction "Any Faction"
     :anarch "Anarch"
     :criminal "Criminal"
     :shaper "Shaper"
     :adam "Adam"
     :apex "Apex"
     :sunny-lebeau "Sunny Lebeau"
     :jinteki "Jinteki"
     :haas-bioroid "Haas-Bioroid"
     :nbn "NBN"
     :weyland-consortium "Weyland Consortium"
     :neutral "Neutral"}
    :format
    {:all "All"
     :any-format "Any Format"
     :standard "Standard"
     :eternal "Eternal"
     :core-experience "Core Experience"
     :snapshot "Snapshot"
     :snapshot-plus "Snapshot Plus"
     :socr "SOCR"
     :classic "Classic"
     :casual "Casual"}
    :card-type
    {:all "All"
     :identity "Identity"
     :agenda "Agenda"
     :asset "Asset"
     :upgrade "Upgrade"
     :operation "Operation"
     :ice "ICE"
     :event "Event"
     :hardware "Hardware"
     :resource "Resource"
     :program "Program"}
    :pronouns
    {:none "Unspecified"
     :any "Any"
     :myodb "Prefer not to say"
     :blank "[blank]"
     :they "They/them"
     :she "She/her"
     :shethey "She/they"
     :he "He/him"
     :hethey "He/they"
     :it "It"
     :ne "Ne/nem"
     :ve "Ve/ver"
     :ey "Ey/em"
     :zehir "Ze/hir"
     :zezir "Ze/zir"
     :xe "Xe/xem"}
    :chat
    {:title "Play Android: Netrunner in your browser"
     :channels "Channels"
     :send "Send"
     :placeholder "Say something..."
     :delete "Delete Message"
     :delete-all "Delete All Messages From User"
     :block "Block User"
     :cancel "Cancel"}
    :nav
    {:chat "Chat"
     :cards "Cards"
     :deck-builder "Deck Builder"
     :play "Play"
     :help "Help"
     :settings "Settings"
     :stats "Stats"
     :about "About"
     :tournaments "Tournaments"
     :admin "Admin"
     :users "Users"
     :features "Features"
     :game-count (fn [[cnt]] (str cnt " Game" (when (not= cnt 1) "s")))}
    :menu
    {:settings :en.nav/settings
     :logout "Jack out"
     :admin :en.nav/admin
     :moderator "Moderator"}
    :card-browser
    {:search-hint "Search cards"
     :sort "Sort by"
     :format "Format"
     :set "Set"
     :side "Side"
     :faction "Faction"
     :type "Type"
     :clear "Clear"
     :select-art "Select Art"
     :update-success "Updated Art"
     :update-failure "Failed to Update Art"
     :sort-by {:faction "Faction"
              :name "Name"
              :type "Type"
              :influence "Influence"
              :cost "Cost"
              :set-number "Set number"}}
    :deck-builder
    {:loading-msg "Loading deck collection..."
     :new-corp "New Corp deck"
     :new-runner "New Runner deck"
     :import-button "Import deck"
     :reset "Reset"
     :import-title "Enter a Public NRDB Deck ID or URL"
     :import "Import"
     :cancel "Cancel"
     :import-placeholder "NRDB ID"
     :deck-count (fn [[cnt]] (str cnt (if (= 1 cnt) " Deck" " Decks")))
     :filtered "(filtered)"
     :save "Save"
     :confirm-delete "Confirm Delete"
     :edit "Edit"
     :delete "Delete"
     :clear-stats "Clear Stats"
     :create-game "Create Game"
     :deck-name "Deck name"
     :format "Format"
     :identity "Identity"
     :deck-notes "Deck notes"
     :decklist "Decklist"
     :decklist-inst "(Type or paste a decklist, it will be parsed)"
     :notes "Notes"
     :add-to-deck "Add to deck"
     :add-cards "Add cards"
     :card-name "Card name"
     :no-decks "No decks"
     :cards "cards"
     :min "minimum"
     :max "maximum"
     :influence "Influence"
     :agenda-points "Agenda points"
     :hash "Tournament hash"
     :why "Why?"
     :legal "legal"
     :illegal "illegal"
     :games "Games"
     :completed "Completed"
     :won "Won"
     :lost "Lost"}
   :lobby
    {:no-games "No games"
     :tournament "Tournament"
     :competitive "Competitive"
     :casual "Casual"
     :new-game "New game"
     :reload "Reload list"
     :load-replay "Load Replay"
     :start-replay "Start replay"
     :save-replay "Save Replay"
     :replay-link-error "Replay link invalid."
     :replay-invalid-file "Select a valid replay file."
     :create "Create"
     :cancel "Cancel"
     :title "Title"
     :side "Side"
     :format "Format"
     :options "Options"
     :spectators "Allow spectators"
     :hidden "Make players' hidden information visible to spectators"
     :password-protected "Password protected"
     :password "Password"
     :start "Start"
     :leave "Leave"
     :swap "Swap sides"
     :waiting "Waiting players deck selection"
     :players "Players"
     :deck-selected "Deck selected"
     :select-deck "Select Deck"
     :chat "Chat"
     :select-title "Select your deck"
     :spectator-count (fn [[cnt]] (str cnt " Spectator" (when (not= cnt 1) "s")))
     :closed-msg "Game lobby closed due to inactivity"
     :title-error "Please fill a game title."
     :password-error "Please fill a password."
     :too-little-data "Too little data"
     :completion-rate "Game Completion Rate"
     :watch "Watch"
     :join "Join"
     :rejoin "Rejoin"
     :private "PRIVATE"
     :reset "Reset Game Name"
     :delete "Delete Game"
     :password-for "Password for"
     :invalid-password "Invalid password"
     :not-allowed "Not allowed"
     :aborted "Connection aborted"}
   :settings
   {:invalid-password "Invalid login or password"
    :invalid-email "No account with that email address exists"
    :updated "Profile updated - Please refresh your browser"
    :updating "Updating profile..."
    :get-log-width "Get current log width"
    :get-log-top "Get current log top"
    :email-title "Change email address"
    :current-email "Current email"
    :desired-email "Desired email"
    :email-placeholder "Email address"
    :enter-valid "Please enter a valid email address"
    :update "Update"
    :cancel "Cancel"
    :email "Email"
    :change-email "Change email"
    :avatar "Avatar"
    :change-avatar "Change on gravatar.com"
    :pronouns "Pronouns"
    :language "Language"
    :sounds "Sounds"
    :enable-lobby-sounds "Enable lobby sounds"
    :enable-game-sounds "Enable game sounds"
    :volume "Volume"
    :layout-options "Layout Options"
    :server-stacking "Server stacking is on by default"
    :runner-layout "Runner layout from Corp perspective"
    :runner-classic "Runner rig layout is classic jnet (Top to bottom: Programs, Hardware, Resources)"
    :runner-reverse "Runner rig layout is reversed (Top to bottom: Resources, Hardware, Programs)"
    :background "Game board background"
    :card-backs "Card backs"
    :game-stats "Game Win/Lose statistics"
    :deck-stats "Deck statistics"
    :always "Always"
    :comp-only "Competitive Lobby Only"
    :none "None"
    :alt-art "Alt arts"
    :show-alt "Show alternate card arts"
    :set-all "Set all cards to"
    :set "Set"
    :reset "Reset All to Official Art"
    :blocked "Blocked users"
    :user-name "User name"
    :block "Block user"
    :update-profile "Update Profile"
    :nisei "NISEI"
    :ffg "FFG"}
  :stats
  {:game-stats "Game Stats"
   :corp-stats "Corp Stats"
   :runner-stats "Runner Stats"
   :clear-stats "Clear Stats"
   :no-log "No log available"
   :view-log "View log"
   :winner "Winner"
   :no-games "No games"
   :all-games "Show all games"
   :shared-games "Only show shared"
   :started "Started"
   :ended "Ended"
   :completed "Completed"
   :not-completed "Not completed"
   :won "Won"
   :lost "Lost"
   :turn-count (fn [[cnt]] (str cnt " turn" (when (not= cnt 1) "s")))
   :lobby "Lobby"
   :format "Format"
   :win-method "Win method"
   :view-games "View games"
   :share "Share replay"
   :download "Download replay"
   :unavailable "Replay unavailable"
   :clicks-gained "Clicks Gained"
   :credits-gained "Credits Gained"
   :credits-spent "Credits Spent"
   :credits-click "Credits by Click"
   :cards-drawn "Cards Drawn"
   :cards-click "Cards Drawn by Click"
   :damage-done "Damage Done"
   :cards-rezzed "Cards Rezzed"
   :tags-gained "Tags Gained"
   :runs-made "Runs Made"
   :cards-accessed "Cards Accessed"}
  :game
  {:keep "Keep"
   :mulligan "Mulligan"
   :close "Close"
   :start "Start Game"
   :remove-tag "Remove Tag"
   :run "Run"
   :purge "Purge"
   :trash-resource "Trash Resource"
   :draw "Draw"
   :gain-credit "Gain Credit"
   :game-start "Game start"
   :start-turn "Start Turn"
   :end-turn "End Turn"
   :mandatory-draw "Mandatory Draw"
   :take-clicks "Take Clicks"
   :hq "HQ"
   :grip "Grip"
   :rfg "Removed from the game"
   :play-area "Play Area"
   :current "Current"
   :scored-area "Scored Area"
   :archives "Archives"
   :max-hand "Max hand size"
   :brain-damage "Brain Damage"
   :tag-count (fn [[base additional total]]
                (str base (when (pos? additional) (str " + " additional)) " Tag" (if (not= total 1) "s" "")))
   :agenda-count (fn [[agenda-point]] (str agenda-point " Agenda Point" (when (not= agenda-point 1) "s")))
   :link-strength "Link Strength"
   :credit-count (fn [[credit run-credit]] (str credit " Credit" (if (not= credit 1) "s" "")
                                                (when (pos? run-credit)
                                                  (str " (" run-credit " for run)"))))
   :click-count (fn [[click]] (str click " Click" (if (not= click 1) "s" "")))
   :bad-pub-count (fn [[base additional]] (str base (when (pos? additional) (str " + " additional)) " Bad Publicity"))
   :mu-count (fn [[unused available]] (str unused " of " available " MU unused"))
   :indicate-action "Indicate action"
   :spec-count (fn [[c]] (str c " Spectator" (when (> c 1) "s")))
   :spec-view "Spectator View"
   :runner-view "Runner View"
   :corp-view "Corp View"
   :leave-replay "Leave Replay"
   :leave "Leave Game"
   :rig-irl "Rig layout: IRL"
   :rig-jnet "Rig layout: jnet"
   :unstack-servers "Unstack servers"
   :stack-servers "Stack servers"
   :unmute "Unmute spectators"
   :mute "Mute spectators"
   :concede "Concede"
   :inactivity "Game closed due to inactivity"
   :server "Server"
   :unimplemented "Unimplemented"
   :abilities "Abilities"
   :let-subs-fire "Let all subroutines fire"
   :subs "Subroutines"
   :actions "Actions"
   :fire-unbroken "Fire unbroken subroutines"
   :stack "Stack"
   :r&d "R&D"
   :shuffle "Shuffle"
   :show "Show"
   :close-shuffle "Close & Shuffle"
   :heap "Heap"
   
   }
   }
   
   :la-pig
   {:missing ":la-pig missing text"
    :side
    {:corp "Orpcay"
     :runner "Unnerray"
     :any-side "Anyay Idesay"
     :all "Allyay"}
    :faction
    {:all "Allyay"
     :any-faction "Anyay Actionfay"
     :anarch "Anarchyay"
     :criminal "Iminalcrimay"
     :shaper "Apershay"
     :adam "Adamyay"
     :apex "Apexyay"
     :sunny-lebeau "Unnsay Ebeaulay"
     :jinteki "Intekijay"
     :haas-bioroid "Aashay-Ioroidbay"
     :nbn "NBNYAY"
     :weyland-consortium "Eylandway Onsortiumcay"
     :neutral "Eutralnay"}
    :format
    {:all "Allyay"
     :any-format "Anyay Ormatfay"
     :standard "Andardstay"
     :eternal "Eternalyay"
     :core-experience "Orecay Experienceyay"
     :snapshot "Apshotsnay"
     :snapshot-plus "Apshotsnay Usplay"
     :socr "SOCRYAY"
     :classic "Assicclay"
     :casual "Asualcay"}
    :card-type
    {:all "Allyay"
     :identity "Identityay"
     :agenda "Agendayay"
     :asset "Assetyay"
     :upgrade "Upgradeyay"
     :operation "Operationyay"
     :ice "ICEYAY"
     :event "Eventyay"
     :hardware "Ardwarehay"
     :resource "Esourceray"
     :program "Ogrampray"}
    :pronouns
    {:none "Unspecifiedyay"
     :any "Anyay"
     :myodb "Eferpray otnay otay aysay"
     :blank "[ankblay]"
     :they "Eythay/emthay"
     :she "Eshay/erhay"
     :shethey "Eshay/eythay"
     :he "Ehay/imhay"
     :hethey "Ehay/eythay"
     :it "Ityay"
     :ne "Enay/emnay"
     :ve "Evay/ervay"
     :ey "Eyay/emay"
     :zehir "Ezay/irhay"
     :zezir "Ezay/irzay"
     :xe "Exay/emxay"}
    :chat
    {:title "Ayplay Android: Etrunnernay inyay ouryay owserbray"
     :channels "Annelschay"
     :send "Endsay"
     :placeholder "Aysay omethingsay..."
     :delete "Eleteday Essagemay"
     :delete-all "Eleteday Allyay Essagesmay Omfray Useryay"
     :block "Ockblay Useryay"
     :cancel "Ancelcay"}
    :nav
    {:chat "Atchay"
     :cards "Ardscay"
     :deck-builder "Eckday Uilderbay"
     :play "Ayplay"
     :help "Elphay"
     :settings "Ettingssay"
     :stats "Atsstay"
     :about "Aboutyay"
     :tournaments "Ournamentstay"
     :admin "Adminyay"
     :users "Usersyay"
     :features "Eaturesfay"
     :game-count (fn [[cnt]] (str cnt (if (= 1 cnt) " Amegay" " Amesgay"))) }
    :menu
    {:settings :la-pig.nav/settings
     :logout "Ackjay outyay"
     :admin :la-pig.nav/admin
     :moderator "Oderatormay"}
    :card-browser
    {:search-hint "Earchsay ardscay"
     :sort "Ortsay ybay"
     :format "Ormatfay"
     :set "Etsay"
     :side "Idesay"
     :faction "Actionfay"
     :type "Etypay"
     :clear "Earclay"
     :select-art "Electsay Artyay"
     :update-success "Updatedyay Artyay"
     :update-failure "Ailedfay otay Updateyay Artyay"
     :sort-by {:faction "Actionfay"
              :name "Amenay"
              :type "Etypay"
              :influence "Influenceyay"
              :cost "Ostcay"
              :set-number "Etsay umbernay"}}
    :deck-builder
    {:loading-msg "Oadinglay eckday ollectioncay..."
     :new-corp "Ewnay Orpcay eckday"
     :new-runner "Ewnay Unnerray eckday"
     :import-button "Importyay Eckday"
     :reset "Esetray"
     :import-title "Enteryay ayay ublicpay bnrday eckday idyay oryay urlyay"
     :import "Importyay"
     :cancel "Ancelcay"
     :import-placeholder "Bnrday idyay"
     :deck-count (fn [[cnt]] (str cnt (if (= 1 cnt) " Eckday" " Ecksday")))
     :filtered "(ilteredfay)"
     :save "Avesay"
     :confirm-delete "Onfirmcay Eleteday"
     :edit "Edityay"
     :delete "Eleteday"
     :clear-stats "Earclay Atsstay"
     :create-game "Eatecray Amegay"
     :deck-name "Eckday Amenay"
     :format "Ormatfay"
     :identity "Identityay"
     :deck-notes "Eckday otesnay"
     :decklist "Ecklistday"
     :decklist-inst "(Ypetay oryay astepay ayay ecklistday, ityay illway ebay arsedpay)"
     :notes "Otesnay"
     :add-to-deck "Addyay otay eckday"
     :add-cards "Addyay ardscay"
     :card-name "Ardcay amenay"
     :no-decks "Onay ecksday"
     :cards "ardscay"
     :min "inimummay"
     :max "aximummay"
     :influence "Influenceyay"
     :agenda-points "Agendayay ointspay"
     :hash "Ournamenttay ashhay"
     :why "Whyay?"
     :legal "egallay"
     :illegal "illegalyay"
     :games "Amesgay"
     :completed "Ompletedcay"
     :won "Onway"
     :lost "Ostlay"}
   :lobby
    {:no-games "Onay amesgay"
     :tournament "Ournamenttay"
     :competitive "Ompetitivecay"
     :casual "Asualcay"
     :new-game "Ewnay amegay"
     :reload "Eloadray istlay"
     :load-replay "Oadlay Eplayray"
     :start-replay "Artst Eplayray"
     :save-replay "Avesay Eplayray"
     :replay-link-error "Eplayray inklay invalidyay."
     :replay-invalid-file "Electsay ayay alidvay eplayray ilefay."
     :create "Eatecray"
     :cancel "Ancelcay"
     :title "Itletay"
     :side "Idesay"
     :format "Ormatfay"
     :options "Optionsyay"
     :spectators "Allowyay ectatorsspay"
     :hidden "Akemay ayersplay iddenhay informationyay isiblevay otay ectatorsspay"
     :password-protected "Asswordpay otectedpray"
     :password "Asswordpay"
     :start "Artstay"
     :leave "Eavelay"
     :swap "Apsway idessay"
     :waiting "Aitingway ayersplay eckday electionsay"
     :players "Ayersplay"
     :deck-selected "Eckday electedsay"
     :select-deck "Electsay eckday"
     :chat "Atchay"
     :select-title "Electsay ouryay eckday"
     :spectator-count (fn [[cnt]] (str cnt " Ectatorspay" (when (not= cnt 1) "s")))
     :closed-msg "Amegay obbylay osedclay ueday otay inactivityay"
     :title-error "Easeplay illfay ayay amegay itletay."
     :password-error "Easepl illfay ayay asswordpay."
     :too-little-data "Ootay ittlelay ataday"
     :completion-rate "Amegay Ompletioncay Ateray"
     :watch "Atchway"
     :join "Oinjay"
     :rejoin "Ejoinray"
     :private "IVATEPRAY"
     :reset "Esetray Amegay Amenay"
     :delete "Eleteday Amegay"
     :password-for "Asswordpay orfay"
     :invalid-password "Nvalidiay asswordpay"
     :not-allowed "Otnay allowedyay"
     :aborted "Onnectioncay abortedyay"}
   :settings
   {:invalid-password "Nvalidiay oginlay oryay asswordpay"
    :invalid-email "Onay accountyay ithway atthay emailyay addressyay existsyay"
    :updated "Ofilepray updatedyay - Leasepay efreshray ouryay owserbray"
    :updating "Updatingyay ofilepray..."
    :get-log-width "Etgay urrentcay oglay idthway"
    :get-log-top "Etgay urrentcay oglay optay"
    :email-title "Angechay emailyay addressyay"
    :current-email "Urrentcay emailyay"
    :desired-email "Esiredday emailyay"
    :email-placeholder "Emailyay addressyay"
    :enter-valid "Easeplay enteryay ayay alidvay emailyay addressyay"
    :update "Updateyay"
    :cancel "Ancelcay"
    :email "Emailyay"
    :change-email "Angechay emailyay"
    :avatar "Avataryay"
    :change-avatar "Angechay onyay gravatar.com"
    :pronouns "Onounspray"
    :language "Anguagelay"
    :sounds "Oundssay"
    :enable-lobby-sounds "Enableyay obbylay oundssay"
    :enable-game-sounds "Enableyay amegay oundssay"
    :volume "Olumevay"
    :layout-options "Ayoutlay Optionsyay"
    :server-stacking "Erversay ackingstay isyay onyay ybyay efaultday"
    :runner-layout "Unnerray ayoutlay omfray Orpcay erspectivepray"
    :runner-classic "Unnerray igray ayoutlay isyay assicclay etjnay (Optay otay ottombay: Ogramspr, Ardwarehay, Esourcesray)"
    :runner-reverse "Unnerray iray ayoutlay isyay eversedray (Optay otay ottombay: Esourcesray, Ardwarehay, Ogramspray)"
    :background "Amegay oardbay ackgroundbay"
    :card-backs "Ardcay acksbay"
    :game-stats "Amegay Inway/Oselay atisticsstay"
    :deck-stats "Eckday atisticsstay"
    :always "Alwaysyay"
    :comp-only "Ompetitivecay Obbylay Onlyay"
    :none "Onenay"
    :alt-art "Altyay artsyay"
    :show-alt "Owshay alternateyay ardcay artsyay"
    :set-all "Etsay allyay ardscay otay"
    :set "Etsay"
    :reset "Esetray Allyay otay Officialyay Artyay"
    :blocked "Ockedblay usersyay"
    :user-name "Useryay amenay"
    :block "Ockblay useryay"
    :update-profile "Updateyay Ofilepray"
    :nisei "ISEINAY"
    :ffg "FFGYAY"}
  :stats
  {:game-stats "Amegay Atsstay"
   :corp-stats "Orpcay Atsstay"
   :runner-stats "Unnerray Atsstay"
   :clear-stats "Earclay Atsstay"
   :no-log "Onay oglay availableyay"
   :view-log "Iewvay oglay"
   :winner "Innerway"
   :no-games "Onay amesgay"
   :all-games "Owshay allyay amesgay"
   :shared-games "Onlyay owshay aredshay"
   :started "Artedstay"
   :ended "Endedyay"
   :completed "Ompletedcay"
   :not-completed "Otnay ompletedcay"
   :won "Onway"
   :lost "Ostlay"
   :turn-count (fn [[cnt]] (str cnt " urntay" (when (not= cnt 1) "s")))
   :lobby "Obbylay"
   :format "Ormatfay"
   :win-method "Inway ethodmay"
   :view-games "Iewvay amesgay"
   :share "Areshay eplayray"
   :download "Ownloadday eplayray"
   :unavailable "Eplayray unavailableyay"
   :clicks-gained "Icksclay Ainedgay"
   :credits-gained "Editscray Ainedgay"
   :credits-spent "Editscray Entspay"
   :credits-click "Editscray ybay Ickclay"
   :cards-drawn "Ardscay Awndray"
   :cards-click "Ardscay Awndray ybay Ickclay"
   :damage-done "Amageday Oneday"
   :cards-rezzed "Ardscay Ezzedray"
   :tags-gained "Agstay Ainedgay"
   :runs-made "Unsray Ademay"
   :cards-accessed "Ardscay Accessedyay"}
  :game
  {:keep "Eepkay"
   :mulligan "Ulliganmay"
   :close "Oseclay"
   :start "Artstay Amegay"
   :remove-tag "Emoveray Agtay"
   :run "Unray"
   :purge "Urgepay"
   :trash-resource "Ashtray Esourceray"
   :draw "Awdray"
   :gain-credit "Aingay Editcray"
   :game-start "Amegay Artstay"
   :start-turn "Artstay Urntay"
   :end-turn "Endyay Urntay"
   :mandatory-draw "Andatorymay Awdray"
   :take-clicks "Aketay Icksclay"
   :hq "HQYAY"
   :grip "Ipgray"
   :rfg "Emovedray omfray ethay amegay"
   :play-area "Ayplay Areayay"
   :current "Urrentcay"
   :scored-area "Oredscay Areayay"
   :archives "Archivesyay"
   :max-hand "Axmay andhay izesay"
   :brain-damage "Ainbray Amageday"
   :tag-count (fn [[base additional total]]
                (str base (when (pos? additional) (str " + " additional)) " Agtay" (if (not= total 1) "s" "")))
   :agenda-count (fn [[agenda-point]] (str agenda-point " Agendayay Ointpay" (when (not= agenda-point 1) "s")))
   :link-strength "Inklay Engthstray"
   :credit-count (fn [[credit run-credit]] (str credit " Editcray" (if (not= credit 1) "s" "")
                                                (when (pos? run-credit)
                                                  (str " (" run-credit " orfay unray)"))))
   :click-count (fn [[click]] (str click " Ickclay" (if (not= click 1) "s" "")))
   :bad-pub-count (fn [[base additional]] (str base (when (pos? additional) (str " + " additional)) " Adbay Ublicitypay"))
   :mu-count (fn [[unused available]] (str unused " ofyay " available " UMYAY unusedyay"))
   :indicate-action "Indicateyay actionyay"
   :spec-count (fn [[c]] (str c " Ectatorspay" (when (> c 1) "s")))
   :spec-view "Ectatorspay Iewvay"
   :runner-view "Unnerray Iewvay"
   :corp-view "Orpcay Iewvay"
   :leave-replay "Eavelay Eplayray"
   :leave "Eavelay Amegay"
   :rig-irl "Igray ayoutlay: IRLYAY"
   :rig-jnet "Igray ayoutlay: etjnay"
   :unstack-servers "Unstackyay erverssay"
   :stack-servers "Ackstay erverssay"
   :unmute "Unmuteyay ectatorsspay"
   :mute "Utemay ectatorsspay"
   :concede "Oncedecay"
   :inactivity "Amegay osedclay ueday otay inactivityay"
   :server "Erversay"
   :unimplemented "Unimplementedyay"
   :abilities "Abilitiesyay"
   :let-subs-fire "Etlay allyay ubroutinessay irefay"
   :subs "Ubroutinessay"
   :actions "Actionsyay"
   :fire-unbroken "Irefay unbrokenyay ubroutinessay"
   :stack "Ackstay"
   :r&d "R&DYAY"
   :shuffle "Uffleshay"
   :show "Owshay"
   :close-shuffle "Osecla & Uffleshay"
   :heap "Eaphay"
   }
   }})

(def opts {:dict translation-dictionary})

(defn tr [resource & params]
  (let [lang (keyword (get-in @app-state [:options :language] "en"))]
    (tempura/tr opts [lang :en] resource (vec params))))

(defn tr-string [prefix s]
  (let [side (lower-case (replace (or s "") " " "-"))
        kw (keyword (str prefix "." side))]
    (tr [kw "Unknown"])))

(def tr-type (partial tr-string "card-type"))
(def tr-side (partial tr-string "side"))
(def tr-faction (partial tr-string "faction"))
(def tr-format (partial tr-string "format"))
(def tr-sort (partial tr-string "card-browser.sort-by"))
(def tr-lobby (partial tr-string "lobby"))
(def tr-pronouns (partial tr-string "pronouns"))
(def tr-watch-join (partial tr-string "lobby"))
