package by.it.academy.commandMain;

import by.it.academy.command.admin.*;
import by.it.academy.command.main.*;
import by.it.academy.command.user.control.*;
import by.it.academy.command.user.registration.*;

/**
 * Created by USER on 02.02.2016.
 */

public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },GOTARIFFMAINPAGE {
        {
            this.command = new GoTariffMainPageCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    GOSERVICEMAINPAGE {
        {
            this.command = new GoServiceMainPageCommand();
        }
    },
    GONEWSMAINPAGE {
        {
            this.command = new GoNewsMainPageCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    },
    GOTARIFFPAGE {
        {
            this.command =  new GoTariffPageCommand();
        }
    },
    GOSERVICEPAGE {
        {
            this.command = new GoServicePageCommand();
        }
    },
    GONUMBERPAGE {
        {
            this.command = new GoNumberPageCommand();
        }
    },
    GOABONENTPAGE {
        {
            this.command = new GoAbonentPageCommand();
        }

    },
    ADDTARIFF {
        {
            this.command = new AddTariffCommand();
        }
    },
    ADDSERVICE {
        {
            this.command = new AddServiceCommand();
        }
    },
    ADDNUMBER {
        {
            this.command = new AddNumberCommand();
        }
    },
    ADDNEWS {
        {
            this.command = new AddNewsCommand();
        }
    },
    CHANGENEWSPAGE {
        {
            this.command = new ChangeNewsPageCommand();
        }
    },
    CHANGENEWSPAGEMAIN {
        {
            this.command = new ChangeNewsPageMainCommand();
        }
    },
    GOCONNECTINGUSERPAGE {
        {
            this.command = new GoConnectingUserPageCommand();
        }

    },
    CONNECTINGTARIFF {
        {
            this.command = new ConnectingTariffCommand();
        }
    },
    CONNECTINGSERVICE {
        {
            this.command = new ConnectingServiceCommand();
        }
    },
    CONNECTINGNUMBER {
        {
            this.command = new ConnectingNumberCommand();
        }
    },
    GOUSERMAIN {
        {
            this.command = new GoUserMainCommand();
        }
    },
    GOCHANGEUSERACCOUNT {
        {
            this.command = new GoChangeUserAccountCommand();
        }
    },
    GOCHANGEUSERTARIFF {
        {
            this.command = new GoChangeUserTariffCommand();
        }
    },
    GOUSERMAINFROMCHANGETARIFF {
        {
            this.command = new GoUserMainFromChangeTariffCommand();
        }
    },
    GOCHANGEUSERSERVICES {
        {
            this.command = new GoChangeUserServicesCommand();
        }
    },
    DISCONNECTINGSERVICE {
        {
            this.command = new GoDisConnectingServiceCommand();
        }
    },
    GONEWSPAGE {
        {
            this.command = new GoNewsPageCommand();
        }
    },
    SORTABONENT {
        {
            this.command = new SortAbonentCommand();
        }
    },
    GOINDEX {
        {
            this.command = new GoIndexCommand();
        }
    }
    ;
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }

}
