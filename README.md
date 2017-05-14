
Simple Virus Detector
=====================

This is an assignment project for Computer Security (CS3052 Assignment 3)

Install
-------

```shell
$ javac virusdetect/*.java
```

Usage
-----

To run on the example virus folder,

```shell
$ java virusdetect/VirusDetect
```

or 

```shell
$ java virusdetect/VirusDetect virus_folder
```

To run on a specific folder,

```shell
$ java virusdetect/VirusDetect relative/path/to/folder
```

Approach
--------

This program uses the md5 hash of a file to detect viruses from [Virus Share](https://virusshare.com/hashes.4n6)

