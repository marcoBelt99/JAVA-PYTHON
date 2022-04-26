#!/usr/bin/env ruby

require 'socket'

server = TCPSever.new 51000
loop do
    client = server.accept
    file_name = client.readline.client
    File.open(file_name,"r") do |f|
        5.times do
            client.puts f.readline
        end
    end
    client.close
end