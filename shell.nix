
{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = with pkgs; [
    jdk21
    maven
    sqlite
  ];

  shellHook = ''
    export JAVA_HOME=${pkgs.jdk21}
    PATH="${pkgs.jdk21}/bin:$PATH"
  '';
}