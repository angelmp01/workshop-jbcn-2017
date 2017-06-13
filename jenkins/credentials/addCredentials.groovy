import com.cloudbees.plugins.credentials.impl.*;
import com.cloudbees.plugins.credentials.*;
import com.cloudbees.plugins.credentials.domains.*;

Credentials c = (Credentials) new UsernamePasswordCredentialsImpl(CredentialsScope.GLOBAL,"gitlab", "Gitlab Credentials", "root", "jBCNConf2017")

SystemCredentialsProvider.getInstance().getStore().addCredentials(Domain.global(), c)