docker build -t quiz-roulette/quiz-log-event-service .

### K8

gcloud builds submit --tag gcr.io/endless-comfort-334004/quiz-log-rest-api

eval $(minikube docker-env)
docker build -t quiz-log-rest-api .


Ref:

- https://msayag.github.io/WebFlux/

```


export NVM_DIR="/Users/Smit/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && . "$NVM_DIR/nvm.sh"  # This loads nvm

alias showFiles='defaults write com.apple.finder AppleShowAllFiles YES; killall Finder /System/Library/CoreServices/Finder.app'
alias hideFiles='defaults write com.apple.finder AppleShowAllFiles NO; killall Finder /System/Library/CoreServices/Finder.app'

export ANDROID_HOME=/usr/local/Caskroom/android-sdk/3859397
#export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home
#export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-16.0.1.jdk/Contents/Home

export ANDROID_SDK_ROOT=$ANDROID_HOME

#export ANDROID_HOME=/<installation location>/android-sdk-macosx
export PATH=${PATH}:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
export PATH=$PATH:/Android/android-sdk-mac_x86/tools


export PATH=${PATH}:/usr/local/mysql/bin
export PATH=${PATH}:/usr/local/Cellar/opencv/3.4.1_5/lib
export PATH=${PATH}:/usr/local/Cellar/maven/3.6.3_1/bin
export PATH=${PATH}:/usr/local/Cellar/opencv/3.4.1_5/share/OpenCV
export PATH=${PATH}:/usr/local/go/bin
export PATH=${PATH}:/Users/Smit/Documents/Dev/blockchain/hyperledger/fabric-samples/bin

export PATH=${PATH}:/Users/Smit/Downloads/chrome/hdac-master/src
export PATH=${PATH}:/Users/Smit/Documents/Dev/spark-2.4.4-bin-hadoop2.6/bin

##
# Your previous /Users/Smit/.bash_profile file was backed up as /Users/Smit/.bash_profile.macports-saved_2017-12-23_at_11:25:56
##

# MacPorts Installer addition on 2017-12-23_at_11:25:56: adding an appropriate PATH variable for use with MacPorts.
export PATH="/opt/local/bin:/opt/local/sbin:$PATH"
# Finished adapting your PATH environment variable for use with MacPorts.


# MacPorts Installer addition on 2017-12-23_at_11:25:56: adding an appropriate MANPATH variable for use with MacPorts.
export MANPATH="/opt/local/share/man:$MANPATH"
# Finished adapting your MANPATH environment variable for use with MacPorts.

export PATH

# Setting PATH for Python 3.7
# The original version is saved in .bash_profile.pysave
PATH="/Library/Frameworks/Python.framework/Versions/3.7/bin:${PATH}"
export PATH
# added by Anaconda3 2019.07 installer
# >>> conda init >>>
# !! Contents within this block are managed by 'conda init' !!
__conda_setup="$(CONDA_REPORT_ERRORS=false '/Users/Smit/anaconda3/bin/conda' shell.bash hook 2> /dev/null)"
if [ $? -eq 0 ]; then
    \eval "$__conda_setup"
else
    if [ -f "/Users/Smit/anaconda3/etc/profile.d/conda.sh" ]; then
        . "/Users/Smit/anaconda3/etc/profile.d/conda.sh"
        CONDA_CHANGEPS1=false conda activate base
    else
        \export PATH="/Users/Smit/anaconda3/bin:$PATH"
    fi
fi
unset __conda_setup
# <<< conda init <<<

# Setting PATH for Python 3.7
# The original version is saved in .bash_profile.pysave
PATH="/Library/Frameworks/Python.framework/Versions/3.7/bin:${PATH}"

JMETER_PATH=/Users/Smit/Downloads/External-Libraries/apache-jmeter-5.4.1
PATH={PATH}:JMETER_PATH

export PATH


#THIS MUST BE AT THE END OF THE FILE FOR SDKMAN TO WORK!!!
export SDKMAN_DIR="/Users/Smit/.sdkman"
[[ -s "/Users/Smit/.sdkman/bin/sdkman-init.sh" ]] && source "/Users/Smit/.sdkman/bin/sdkman-init.sh"

[[ -s "$HOME/.rvm/scripts/rvm" ]] && source "$HOME/.rvm/scripts/rvm" # Load RVM into a shell session *as a function*

```