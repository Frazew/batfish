parser grammar CiscoNxos_bfd;

import CiscoNxos_common;

options {
  tokenVocab = CiscoNxosLexer;
}

s_bfd
:
  BFD
  (
    bfd_echo_interface
    | bfd_parameters
  )
;

bfd_echo_interface
:
  ECHO_INTERFACE name = interface_name NEWLINE
;

bfd_parameters
:
  INTERVAL (interval = uint16) MIN_RX (min_rx = uint16) MULTIPLIER (multiplier = uint8) NEWLINE
;