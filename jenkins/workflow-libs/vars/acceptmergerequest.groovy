@Grab('org.gitlab4j:gitlab4j-api:4.2.0')
import org.gitlab4j.api.*
import utils.MergeRequestApi2

def call(String projectName, String mergeid) {
    println "Accept merge request[$mergeid] of project[$projectName]"
    
    GitLabApi gitLabApi = GitLabApi.login('http://gitlab', 'root', 'jBCNConf2017');
    
    ProjectApi projectApi  = gitLabApi.getProjectApi()
    
    def projectId = null
    
    for(def project : projectApi.getProjects()) {
        if(projectName.equals(project.getName())) {
            projectId = project.getId()
            break
        }
    }
    
    MergeRequestApi2 mergeRequestApi2 = new MergeRequestApi2(gitLabApi)
    
    mergeRequestApi2.accept(projectId, mergeid.toInteger())
    //mergeRequestApi2.delete(projectId, mergeid.toInteger())
}
