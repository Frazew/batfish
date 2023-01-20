parser grammar CiscoNxos_dhcp;

import CiscoNxos_common;

options {
  tokenVocab = CiscoNxosLexer;
}

// TODO: flesh out.

ip_dhcp
:
  DHCP
  (
    ip_dhcp_relay
  )
;

ip_dhcp_relay
:
  RELAY
  (
    ip_dhcp_relay_information_option
    | NEWLINE
  )
;

ip_dhcp_relay_information_option
:
  INFORMATION OPTION VPN? NEWLINE
;

ipv6_dhcp: DHCP RELAY NEWLINE;