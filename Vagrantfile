# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.require_version '>= 1.9.3'

Vagrant.configure(2) do |config|

  config.vm.box = 'ubuntu/xenial64'
  config.vm.network "private_network", ip: "192.168.30.30"

  config.vm.network :forwarded_port, guest: 10000, host: 10000
  config.vm.network :forwarded_port, guest: 11000, host: 11000
  config.vm.network :forwarded_port, guest: 12000, host: 12000
  config.vm.network :forwarded_port, guest: 13000, host: 13000
  config.vm.network :forwarded_port, guest: 14000, host: 14000
  config.vm.network :forwarded_port, guest: 15000, host: 15000
  config.vm.network :forwarded_port, guest: 8443, host: 8443
  config.vm.network :forwarded_port, guest: 50000, host: 50000

  config.vm.synced_folder "/home/jtimon/IdeaProjects/workshop-jbcn-2017", "/workshop-jbcnconf-2017"
  #config.vm.synced_folder "<CHANGE_YOUR_PROJETC_PATH_HERE>", "/workshop-jbcn-2017"

  config.vm.provider "virtualbox" do |vb|
      vb.memory = "8092"
      vb.cpus = "4"
    end
  config.vm.provision "shell", inline: <<-SHELL
    # Install docker and docker compose
    sudo -i
    apt-get update && apt install -y curl
    echo 'debconf debconf/frontend select Noninteractive' | debconf-set-selections
    curl -sSL https://get.docker.com/ | sh
    usermod -aG docker vagrant
    curl -L https://github.com/docker/compose/releases/download/1.13.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose
    chmod +x /usr/local/bin/docker-compose
  SHELL
end