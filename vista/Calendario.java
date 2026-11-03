package ducktimer.vista;

import javax.swing.JInternalFrame;

/*
 * Integración pendiente:
 * - principal: agregar el botón "CALENDARIO", su panel en el menú lateral,
 *   una instancia Calendario y su ActionListener para mostrarla en center.
 * - Alarms: agregar una acción para abrir Calendario y usar la fecha
 *   seleccionada al crear o editar una alarma.
 * - AlarmService: comparar fecha y hora completas de cada alarma; mantener
 *   aquí la lógica de disparo, no en esta ventana.
 * - Time: reemplazar o complementar la hora suelta con un tipo de dato que
 *   también almacene fecha. Guardar y cargar esa fecha en TimeUtils.
 * - Reloj: mantenerlo como reloj de la fecha actual; solo conectarlo si se
 *   requiere que muestre la fecha seleccionada en Calendario.
 * - Temporizador: no conectarlo para temporizadores normales. La programación
 *   por fecha debe ir en un servicio de funcion y usar el dato de tipo con fecha.
 * - Cronometro y CronometroFuncion: no conectarlos al calendario para medir
 *   tiempo transcurrido; solo vincularlos si se necesita guardar sesiones.
 * - Esta clase: agregar la interfaz y selección/navegación de fechas.
 *   No guardar alarmas ni implementar temporizadores aquí.
 */


public class Calendario extends JInternalFrame{
}
