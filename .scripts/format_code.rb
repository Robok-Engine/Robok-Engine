# Copyright 2025 Aquiles Trindade (trindadedev).
# Licensed under the Apache 2.0 License.

require 'fileutils'
require 'open-uri'

if ARGV.length != 1
  puts "Usage: ruby file.rb <base_dir>"
  exit 1
end

# Variables
TO_FORMAT_DIR = ARGV[0]
CACHE_DIR = "#{ENV['HOME']}/.cache/trindadedev/formatters"
FileUtils.mkdir_p(CACHE_DIR)

# Formatter Configurations
FORMATTERS = {
  java: {
    name: "Google Java Formatter",
    file: "google-java-format.jar",
    version: "1.25.2",
    url_template: "https://github.com/google/google-java-format/releases/download/v%{version}/google-java-format-%{version}-all-deps.jar",
    file_ext: "*.java",
    args: ["--replace"]
  },
  kotlin: {
    name: "Facebook KtFmt",
    file: "ktfmt.jar",
    version: "0.53",
    url_template: "https://github.com/facebook/ktfmt/releases/download/v%{version}/ktfmt-%{version}-jar-with-dependencies.jar",
    file_ext: "*.kt",
    args: ["--google-style"]
  }
}

# Download formatter if it doesn't exist
def download_formatter(formatter)
  path = File.join(CACHE_DIR, formatter[:file])
  return path if File.exist?(path)

  puts "Downloading #{formatter[:name]}..."
  url = formatter[:url_template] % { version: formatter[:version] }

  URI.open(url) do |u|
    File.open(path, 'wb') { |f| f.write(u.read) }
  end

  path
end

# Format files of a given type
def format_files(key, formatter)
  print "Do you want to format all #{key.to_s.capitalize} files in this directory and subdirectories? (Y/N): "
  answer = STDIN.gets.strip.downcase
  return unless answer.start_with?("y")

  jar_path = download_formatter(formatter)
  puts "Formatting #{key.to_s.capitalize} files..."

  Dir.glob("#{TO_FORMAT_DIR}/**/#{formatter[:file_ext]}").each do |file|
    system("java", "-jar", jar_path, *formatter[:args], file)
  end
end

# Run formatters
FORMATTERS.each do |key, formatter|
  format_files(key, formatter)
end